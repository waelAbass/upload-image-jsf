package beans;

import entities.Image;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

@ManagedBean
@ViewScoped
public class ImageBean {

    private Part image;
    private String currentImagename;
    @ManagedProperty(value = "#{dBBean}")
    private DBBean dbbean;

    public void setDbbean(DBBean dbbean) {
        this.dbbean = dbbean;
    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {
        this.image = image;
    }

    public String uploadImage() {
        try {
            if (image != null) {
                Map<String, Image> db = dbbean.getDb();
                Image img = new Image();
                img.setName(image.getSubmittedFileName());
                img.setContenttype(image.getContentType());
                byte[] content = IOUtils.toByteArray(image.getInputStream());
                img.setContent(content);
                db.put(img.getName(), img);
                currentImagename = img.getName();
                System.out.println("Image has been uploaded");
            } else {
                FacesContext.getCurrentInstance().addMessage("image-messages", new FacesMessage(FacesMessage.SEVERITY_FATAL, "no image selected", null));
            }
        } catch (IOException ex) {
            Logger.getLogger(ImageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public String getCurrentImagename() {
        return currentImagename;
    }

    

}
