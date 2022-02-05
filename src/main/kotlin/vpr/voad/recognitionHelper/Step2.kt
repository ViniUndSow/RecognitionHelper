package vpr.voad.recognitionHelper

import org.slf4j.LoggerFactory
import vpr.voad.recognitionHelper.util.FilePaths
import java.util.logging.Logger
import kotlin.io.path.pathString
import kotlin.io.path.writeText

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

    val targetCardId = "40044918"

    val logger = LoggerFactory.getLogger("Step 2")
    val allCardFolders = FilePaths.IMAGE_SOURCE_DIRECTORY.toFile().listFiles()

    // gets all card images from one ID
    val targetCardFolder = allCardFolders.find {
        it.name.equals(targetCardId)
    }

    // gets the rest of folders with the card ids no equal to the id
    val allOtherCardFolders = allCardFolders.filterNot { it.name.equals(targetCardId)}.filter { it.name.substringAfterLast("\\").contains(Regex("[0-9]")) }
    println(targetCardFolder)


    // Copys all files into the right folders.

    targetCardFolder!!.listFiles().forEach {
        it.copyTo(
                target = FilePaths.POSITIVE_IMAGES_DIRECTORY.resolve(it.name.replaceAfter(".","jpg")).toFile(),
                overwrite = true
        )
    }


    var negativeFileString = ""
    allOtherCardFolders.forEach { allFolders ->
        allFolders.listFiles().forEach { images ->
            val targetFile = FilePaths.NEGATIVE_IMAGES_DIRECTORY.resolve("${allFolders.name}_${images.name.replaceAfter(".","jpg")}").toFile()
            images.copyTo(
                    target = targetFile,
                    overwrite = true
            )
            negativeFileString += "negative/${targetFile.name}\n"
        }
    }

    FilePaths.NEGATIVE_IMAGES_OUTPUT_FILE.writeText(negativeFileString)
}