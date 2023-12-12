package com.example.demoom.example.Models;

import DAO.DAO;
import TableMapping.Column;
import TableMapping.TableInfo;

@TableInfo(name="look_matiere",user="postgres",pass="Andyh123.",database="projet1")
public class Look_Matiere extends DAO{
    @Column(isPrimary= true, name="id")
    Integer id;
    @Column(name="idlook")
    Integer look;
    @Column(name="idmatiere")
    Integer matiere;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id=id;
   }

   public Integer getLook(){
        return this.look;
   }

   public void setLook(Integer look){
    this.look=look;
   }

   public Integer getMatiere(){
    return this.matiere;
    }

    public void setMatiere(Integer matiere){
        this.matiere=matiere;
    }

}
