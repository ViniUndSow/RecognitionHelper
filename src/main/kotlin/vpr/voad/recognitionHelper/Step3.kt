package vpr.voad.recognitionHelper
/*
    In the next step just download opencv 3.x.x
    Please use intelliJ for the next steps.
    - Press ALT + F12
    - type cd src/main/resources
    - after that type copy your path to opencv... should look like that:
        - C:\OpenCV\opencv\build\x64\vc15\bin\opencv_annotation.exe
        - if you found that path copy it with the annotation.exe at the end.
    - add thouse params at the end: --annotations=positive.txt --images=positive/
    -- should look like hat: C:\OpenCV\opencv\build\x64\vc15\bin\opencv_annotation.exe --annotations=positive.txt --images=positive/
    ---------------------------------------------------------------------------------------------------------------
    A Window will open with your Images from the positive folder.
    That is the Recognition part.
    Controls:
    - Mouse Hold | Draws a square what the recognition should use.
    - C | Confirm you chosen square.
    - D | Delete the last square.
    - N | Next image.
    After that go to Step 4.

 */