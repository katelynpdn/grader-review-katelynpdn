CPATH='.:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission
echo 'Finished cloning'


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests
if [[ -f student-submission/ListExamples.java ]]
then
    echo "File Found"
else
    echo "File Not Found"
    exit
fi

cp TestListExamples.java grading-area
cp student-submission/ListExamples.java grading-area
cp -r lib grading-area

cd grading-area
javac -cp $CPATH *.java
if [ $? -ne 0 ]
then
    echo "Compile error"
    exit 1
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > junit-output.txt

cat junit-output.txt
lastline=$(cat junit-output.txt | tail -n 2 | head -n 1)
if [[ $(echo $lastline | awk '{print $1}') == "Tests" ]]
then
    test=$(echo $lastline | awk -F', ' '{print $1}' | awk '{print $3}')
    failures=$(echo $lastline | awk -F', ' '{print $2}' | awk '{print $2}')
    successes=$(( test - failures ))
else
    successes=3
    test=3
fi
echo "Your score is $successes / $test tests passed"