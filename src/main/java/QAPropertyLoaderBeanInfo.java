import org.apache.jmeter.testbeans.BeanInfoSupport;
import org.apache.jmeter.testbeans.gui.FileEditor;

import java.beans.PropertyDescriptor;

public class QAPropertyLoaderBeanInfo extends BeanInfoSupport {
    private static final String PROPERTY_FILE_PATH = "propFilePath";

    public QAPropertyLoaderBeanInfo() {
        super(QAPropertyLoader.class);
        PropertyDescriptor p = property(PROPERTY_FILE_PATH);
        p.setValue(NOT_UNDEFINED, true);
        p.setValue(DEFAULT, "");
        p.setPropertyEditorClass(FileEditor.class);
    }
}
