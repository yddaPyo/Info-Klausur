import java.io.*

class AccessToFile {

    fun reader(path: String): Reader {
        return InputStreamReader(this.javaClass.getResourceAsStream(path))
    }
    fun writer(path:String): Writer {
        val file = File(path)
        return FileWriter(file)
    }
}

