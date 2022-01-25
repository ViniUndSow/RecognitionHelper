package vpr.voad.recognitionHelper.util

import org.slf4j.LoggerFactory
import java.nio.file.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.createFile
import kotlin.io.path.exists
import vpr.voad.recognitionHelper.util.enums.FileFolderType
import vpr.voad.recognitionHelper.util.enums.PositiveNegativeType

class FilePaths {

    companion object {

        private val logger = LoggerFactory.getLogger(javaClass)

        // FOLDER PATHS
        val NEGATIVE_IMAGES_DIRECTORY: Path = Path.of("src/main/resources/negative")
        val POSITIVE_IMAGES_DIRECTORY: Path = Path.of("src/main/resources/positive")

        // Files that contain a list of images which for creating an valid file.
        val NEGATIVE_IMAGES_OUTPUT_FILE: Path = Path.of("src/main/resources/negative.txt")
        val POSITIVE_IMAGES_OUTPUT_FILE: Path = Path.of("src/main/resources/positive.txt")

        val RESULT_CASCADE_DIRECTORY: Path = Path.of("src/main/resources/cascade")

        fun createDirectory(path: Path) {
            createDirectoryOrFileIfNotExisting(path = path, type = FileFolderType.DIRECTORY)
        }

        fun createFile(path: Path) {
            createDirectoryOrFileIfNotExisting(path = path, type = FileFolderType.FILE)
        }

        private fun createDirectoryOrFileIfNotExisting(path: Path, type: FileFolderType) {
            if (!path.exists()) {
                logger.info("${type.name} does not exist. Creating... ")
                try {
                    when (type) {
                        FileFolderType.DIRECTORY -> path.createDirectory()
                        FileFolderType.FILE -> path.createFile()
                    }
                    logger.info("Successfully created ${type.name}. [Path=$path]")

                } catch (e: Exception) {
                    logger.error("Something went wrong while creating. [Type=$type, Path=$path, Exception=${e.stackTrace}]")
                }
            } else {
                logger.info("${type.name} is already existing [Path=$path]")
            }
        }

        fun writeNegativeFile() {
            val images = NEGATIVE_IMAGES_DIRECTORY.toFile().listFiles()
            var targetString = ""

            images.forEach {
                targetString += "negative/${it.name}\n"
                logger.info("Adding image to negative file. [imageName=${it.name}]")
            }
            NEGATIVE_IMAGES_OUTPUT_FILE.toFile().writeText(targetString)
        }

    }


}