package vpr.voad.recognitionHelper

import vpr.voad.recognitionHelper.util.FilePaths

/*
    All images get saved with \ instead of the wanted /.
    Step 4 Replaced all \ with the / one.
    After the execute move to step 5.
 */
fun main() {
    val positiveFile = FilePaths.POSITIVE_IMAGES_OUTPUT_FILE.toFile()
    positiveFile.writeText(positiveFile.readText().replace("\\", "/"))
}