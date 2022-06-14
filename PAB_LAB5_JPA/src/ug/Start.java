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
    
    public void zapisz(Student student) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("PAB_LAB5_JPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(student);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }
     
    public void zapisz(Grupa grupa) {
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("PAB_LAB5_JPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(grupa);
            em.getTransaction().commit();
        }
        catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
        finally {
            em.close();
        }
    }
        
        EntityManagerFactory emf;
        public EntityManager getEntityManager() {
            if (emf==null) emf=Persistence.createEntityManagerFactory("PAB_LAB5_JPAPU");
            return emf.createEntityManager();
        }

         
         public void studenci(JTextArea tDane) {
            EntityManager em=getEntityManager();
            //metoda .findall zostala wygenerowana przez konstruktor w pliku student.java
            TypedQuery<Student> q = em.createNamedQuery("Student.findAll",Student.class);
            List<Student> rezultat=q.getResultList();
            tDane.setText(rezultat.toString());
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
         
        public void studenci(String imie, String nazwisko) {
            EntityManager em=getEntityManager();
            TypedQuery<Student> q = em.createNamedQuery("Student.findByFirstLastName",Student.class);
            q.setParameter("firstName", imie);
            q.setParameter("lastName", nazwisko);
            List<Student> rezultat=q.getResultList();
            
            
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s = new Student(275306,"Dominik","Deptuła","dominik@deptula.pl","S22-32");
        Grupa g=new Grupa();
        g.setGroupNumber("S22-32");
        g.setFieldOfStudy("Computer Science and Econometrics");
        Start start=new Start();
        start.zapisz(g);
        //start.zapisz(s);
        //start.studenci();
        //start.studenci(275306);
        start.studenci("Dominik","Deptuła");
        
        
        

    }
    
}
