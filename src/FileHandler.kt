import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class FileHandler(fileName: String?) {
    private var fileString: String

    init {
        val wholeFile = StringBuilder()
        try {
            for (line in fileName?.let { Paths.get(it) }?.let { Files.readAllLines(it, StandardCharsets.ISO_8859_1) }!!) {
                wholeFile.append(line).append("\n")
            }
        } catch (ioException: IOException) {
            System.err.println("Exception: $ioException")
        }
        fileString = wholeFile.toString()
    }

    fun getFileString(): List<String> {
        return fileString.split("\n");
    }
}
