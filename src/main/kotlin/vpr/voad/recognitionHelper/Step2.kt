package vpr.voad.recognitionHelper

import org.slf4j.LoggerFactory
import vpr.voad.recognitionHelper.util.FilePaths
import java.util.logging.Logger

/*
    This is the 2. Step.
 */
/*
    Before:
    *   Before executing please place the picture files for the targeted card into the positive folder.
    *   After that place at least the double amount of pictures of cards into the negative folder.
    If this step is executed all files from the folders get written into the corresponding file.
 */
fun main() {

    val targetCardId = "17588"

    val logger = LoggerFactory.getLogger("Step 2")
    val allCardFolders = FilePaths.IMAGE_SOURCE_DIRECTORY.toFile().listFiles()

    val targetCardFolder = allCardFolders.find {
        it.name.equals(targetCardId)
    }

    val allOtherCardFolders = allCardFolders.filterNot { it.name.equals(targetCardId) }


    // Datein in die Zielordner kopieren, anschliesend die Zielordner clearen.
}