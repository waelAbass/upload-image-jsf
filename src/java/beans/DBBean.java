/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Image;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

@ManagedBean(eager = true)
@ApplicationScoped
public class DBBean {

    private Map<String, Image> db;

    @PostConstruct
    public void init() {
        db = new HashMap<>();
    }

    public Map<String, Image> getDb() {
        return db;
    }

}
