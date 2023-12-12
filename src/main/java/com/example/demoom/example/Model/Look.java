package com.example.demoom.example.Models;

import DAO.DAO;
import TableMapping.Column;
import TableMapping.TableInfo;
import java.util.Vector;
import java.sql.*;
import database.Connector;

@TableInfo(name="Look",user="postgres",pass="Andyh123.",database="projet1")
public class Look extends DAO {
    @Column(isPrimary= true, name="id")
    Integer id;
    @Column(name="nomlook")
    String nom;

    Vector<String> ListeMatiere;
    
    public Integer getId(){
        return this.id;
    }

    public String getNom(){
        return this.nom;
    }

    public void setId(Integer id){
         this.id=id;
    }

    public void setNom(String nom){
        this.nom=nom;
   }

    public Vector<String> getListeMatiere() {
        return ListeMatiere;
    }


    public void setListeMatiere(Vector<String> listeMatiere) {
        ListeMatiere = listeMatiere;
    }

    public void GetterMatiere(){
        Connection con=null;
        try{
            con = new Connector().postgresql("postgres","Andyh123.","projet1");
            Statement state=con.createStatement();
            ResultSet res=state.executeQuery("SELECT nommatiere FROM v_look_matiere WHERE idlook='"+ this.getId()+"'");
            this.ListeMatiere=new Vector();
            while(res.next()){
                this.ListeMatiere.add(res.getString("nommatiere"));
            }
        }catch(Exception e){
            e.printStackTrace();        
        }finally{
            try{
                con.close();
            }catch(Exception e){

            }
        }
    }
}
