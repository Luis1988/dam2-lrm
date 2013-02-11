package ejemplosOracle;

import java.io.*;
import java.sql.*;

public class RecuperaImagen {
	
	public static void RecuperarBLOB
    (Connection cn,  String idBLOB, String path)
    throws SQLException, IOException
    {
        FileOutputStream fos = null;
        Statement st = null;
        ResultSet rs = null;
        String sql ="select COLOR, " +
                    "       CBLOB, " + 
                    "from COLORES " + 
                    "WHERE COLOR = '" + idBLOB + "' ";
      
        try{
            st = cn.createStatement();        
            rs = st.executeQuery(sql);
            if (rs.next()) 
            {                
                String pathname= 
                path + "\\" + rs.getString("COLOR") ;
                File file = new File(pathname);
                fos = new FileOutputStream(file);                    
                Blob bin = rs.getBlob("CBLOB");
                InputStream inStream = bin.getBinaryStream();
                int size = (int)bin.length();
                byte[] buffer = new byte[size];
                int length = -1;
                while ((length = inStream.read(buffer)) != -1)
                {
                  fos.write(buffer, 0, length);                
                }                                        
            }
        }
        catch (IOException ioe)
        {
            throw new IOException(ioe.getMessage());
        }
        finally 
        {
            if (fos != null)
                fos.close();
            if (rs != null)
                rs.close();
            rs = null;
            st = null;        
        }        
    }

}
