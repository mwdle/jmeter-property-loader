import org.apache.jmeter.config.ConfigTestElement;
import org.apache.jmeter.services.FileServer;
import org.apache.jmeter.testbeans.TestBean;
import org.apache.jmeter.testelement.TestStateListener;
import org.apache.jmeter.util.JMeterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JMeterPropertyLoader extends ConfigTestElement implements TestBean, TestStateListener {

    private final transient Logger log;
    private String propFilePath;

    public JMeterPropertyLoader() {
        super();
        log = LoggerFactory.getLogger(JMeterPropertyLoader.class);
    }

    @Override
    public void testStarted() {
        log.info("Starting JMeterPropertyLoader");
        try {
            Path path = Paths.get(propFilePath);
            if (!path.isAbsolute()) {
                path = Paths.get(FileServer.getFileServer().getBaseDir(), path.toString());
            }
            log.info("Loading properties from file {}", path);
            try (FileInputStream fis = new FileInputStream(path.toString())) {
                JMeterUtils.getJMeterProperties().load(fis);
            }
            log.info("Properties successfully loaded.");
        } catch (InvalidPathException e) {
            log.error("Invalid property file path: {}", propFilePath);
        } catch (FileNotFoundException e) {
            log.error("No property file found at path: {}", propFilePath);
        } catch (IOException e) {
            log.error("Could not read property file: {}", e.getMessage());
        }
    }

    @Override
    public void testStarted(String s) {
        testStarted();
    }

    @Override
    public void testEnded() {
        log.info("Shutting down JMeterPropertyLoader");
    }

    @Override
    public void testEnded(String s) {
        testEnded();
    }

    public String getPropFilePath() {
        return propFilePath;
    }

    public void setPropFilePath(String propFilePath) {
        this.propFilePath = propFilePath;
    }
}
