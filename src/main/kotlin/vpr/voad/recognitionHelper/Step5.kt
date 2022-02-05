package vpr.voad.recognitionHelper

/*
    In the Terminal (ALT + F12) write:

    //The Num part is how many samples should be made
    C:\OpenCV\opencv\build\x64\vc15\bin\opencv_createsamples.exe -info positive.txt -w 24 -h 24 -num 1000 -vec pos.vec

    After that:
    NumPos less to be higher that "Created x samples" from the step before
    D:/opencv/build/x64/vc15/bin/opencv_traincascade.exe -data cascade/ -vec pos.vec -bg negative.txt -w 24 -h 24 -numPos 50 -numNeg 100 -numStages 10

 */