package vpr.voad.recognitionHelper

import vpr.voad.recognitionHelper.util.FilePaths

/*
    Clear all folders.
 */
fun main() {

    // Delete all images from the Pos folder
    FilePaths.POSITIVE_IMAGES_DIRECTORY.toFile().listFiles().forEach {
        it.delete()
    }

    // Deletes all images from the neg folder.
    FilePaths.NEGATIVE_IMAGES_DIRECTORY.toFile().listFiles().forEach {
        it.delete()
    }

    //Clears the Postive File
    FilePaths.POSITIVE_IMAGES_OUTPUT_FILE.toFile().writeText(text = "")
}