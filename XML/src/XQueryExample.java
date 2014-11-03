
import com.saxonica.xqj.SaxonXQDataSource;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author oscar
 */
public class XQueryExample {
  public static void main(String []args)
  {
    try {
     XQDataSource ds = new SaxonXQDataSource();
XQConnection conn = ds.getConnection();
XQPreparedExpression exp = conn.prepareExpression("doc('file:/some/file.xml')/child::node()");
XQResultSequence result = exp.executeQuery();
while(result.next()) {
    System.out.println(result.getItemAsString(null));
}
      
// Free all resources created by the connection
      conn.close();
    } catch (XQException ex) {
      Logger.getLogger(XQueryExample.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
