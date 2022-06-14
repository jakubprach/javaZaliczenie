/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ug;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JTextArea;

/**
 *
 * @author domin
 */
public class Start {
    
        
        EntityManagerFactory emf;
        public EntityManager getEntityManager() {
            if (emf==null) emf=Persistence.createEntityManagerFactory("PAB_LAB5_JPAPU");
            return emf.createEntityManager();
        }

         
         public String equation(Integer index) {
            EntityManager em=getEntityManager();
            //metoda .findbyIndexNumber zostala wygenerowana przez konstruktor w pliku student.java
            TypedQuery<Equation> q = em.createNamedQuery("Equation.findById",Equation.class);
            q.setParameter("id", index);
            List<Equation> rezultat=q.getResultList();
            
            Equation first = rezultat.get(0);
            
            return first.getEquation();

        }
         
         public String getEquationResult(Integer index) {
            EntityManager em=getEntityManager();
            //metoda .findbyIndexNumber zostala wygenerowana przez konstruktor w pliku student.java
            TypedQuery<Equation> q = em.createNamedQuery("Equation.findById",Equation.class);
            q.setParameter("id", index);
            List<Equation> rezultat=q.getResultList();
            
            Equation first = rezultat.get(0);
            
            return first.getResult();

        }
         
         public int getAllEquations() {
            EntityManager em=getEntityManager();
            //metoda .findall zostala wygenerowana przez konstruktor w pliku student.java
            TypedQuery<Equation> q = em.createNamedQuery("Equation.findAll",Equation.class);
            List<Equation> rezultat=q.getResultList();
            System.out.print(rezultat.size());  
            return rezultat.size();
            
        }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    }
    
}
