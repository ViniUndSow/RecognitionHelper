package vpr.voad.recognitionHelper

import vpr.voad.recognitionHelper.util.FilePaths

/*
    This is the first step.
 */
/*
    We basically start here.
    It only needs to be executed one time or when a file is deleted.
 */
fun main() {
    createAllDirectories()
    createAllFiles()
}

fun createAllFiles() {
    FilePaths.createFile(path = FilePaths.NEGATIVE_IMAGES_OUTPUT_FILE)
    FilePaths.createFile(path = FilePaths.POSITIVE_IMAGES_OUTPUT_FILE)
}

fun createAllDirectories() {
    FilePaths.createDirectory(path = FilePaths.POSITIVE_IMAGES_DIRECTORY)
    FilePaths.createDirectory(path = FilePaths.NEGATIVE_IMAGES_DIRECTORY)
    FilePaths.createDirectory(path = FilePaths.RESULT_CASCADE_DIRECTORY)
}

