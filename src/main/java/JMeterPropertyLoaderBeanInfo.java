import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.FileEditor;

import java.beans.PropertyDescriptor;

public class JMeterPropertyLoaderBeanInfo extends BeanInfoSupport {
    private static final String PROPERTY_FILE_PATH = "propFilePath";

    public JMeterPropertyLoaderBeanInfo() {
        super(JMeterPropertyLoader.class);
        PropertyDescriptor p = property(PROPERTY_FILE_PATH);
        p.setValue(NOT_UNDEFINED, true);
        p.setValue(DEFAULT, "");
        p.setPropertyEditorClass(FileEditor.class);
    }
}