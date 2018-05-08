import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.InputStream;
import java.net.URI;

public class FileSystemCat {

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        String uri = args[0];
        FileSystem fs = FileSystem.get(URI.create(uri), conf);

        InputStream in = null;

        try{
            in = fs.open(new Path(uri));
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }

}
