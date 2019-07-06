/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author AFAQE3
 */
public class Image {

   // private Integer id;
    private String Contenttype;
    private String name;
    private byte[] content;

   

    public String getContenttype() {
        return Contenttype;
    }

    public void setContenttype(String Contenttype) {
        this.Contenttype = Contenttype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
    
}
