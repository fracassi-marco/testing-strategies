package utils

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import javax.servlet.Servlet

class ApplicationServer(port: Int, private val servlet: Servlet) {

    private val server: Server = Server(port)

    fun start(): ApplicationServer {
        val handler = ServletContextHandler()
        handler.addServlet(ServletHolder(servlet), "/*")
        server.handler = handler
        server.start()

        return this;
    }

    fun stop() {
        server.stop()
    }
}