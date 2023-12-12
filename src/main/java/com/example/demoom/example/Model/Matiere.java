package com.example.demoom.example.Models;

import DAO.DAO;
import TableMapping.Column;
import TableMapping.TableInfo;

@TableInfo(name="Matiere",user="postgres",pass="Andyh123.",database="projet1")
public class Matiere extends DAO {
    @Column(isPrimary= true, name="id")
    Integer id;
    @Column(name="nommatiere")
    String nom;
    
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
}
