import java.io.File;
import javax.swing.filechooser.FileFilter;

class MyTextFileFilter
  extends FileFilter
{
  public boolean accept(File file)
  {
    return (file.isDirectory()) || (file.getAbsolutePath().endsWith(".txt"));
  }
  
  public String getDescription()
  {
    return "Text Documents (*.txt)";
  }
}
