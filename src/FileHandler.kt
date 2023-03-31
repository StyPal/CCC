import java.io.FileWriter
import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

class FileHandler(fileName: String?) {
    private var name: String = ""
    private var fileString: String
    private var builder: StringBuilder = java.lang.StringBuilder()

    init {
        if (fileName != null) {
            name = fileName
        }
        val wholeFile = StringBuilder()
        try {
            for (line in "./input/$name".let { Paths.get(it) }.let { Files.readAllLines(it, StandardCharsets.ISO_8859_1) }) {
                wholeFile.append(line).append("\n")
            }
        } catch (iox: IOException) {
            System.err.println("Exception: $iox")
        }
        fileString = wholeFile.toString()
        println(fileString)
    }

    fun getList(): List<String> {
        return fileString.split("\n");
    }

    fun writeFile() {
        val temp = builder.toString()
        try {
            val fw = FileWriter("./output/$name")
            fw.write(temp)
            fw.close()
        } catch (ignored: IOException) {
        }
    }

    fun appendToStringBuilder(c: String) {
        builder.append(c)
    }
}
