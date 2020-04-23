package test;

import javax.persistence.*;
import javax.swing.text.html.parser.Entity;
import java.util.List;

public class Demo {
    static EntityManagerFactory emf= Persistence.createEntityManagerFactory("sampleapp");

    static void saveData(Student s){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("sampleapp");
    EntityManager em=emf.createEntityManager();
    EntityTransaction tx=em.getTransaction();
    tx.begin();
//
  em.persist(s);


    tx.commit();
    em.close();
    emf.close();
}
static Student searchData(int id){
    EntityManagerFactory emf= Persistence.createEntityManagerFactory("sampleapp");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();

        Student s= em.find(Student.class,id);
       tx.commit();
       em.close();
       emf.close();
       return s;


}
    static void updateData(int id,String name){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("sampleapp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student s = em.find(Student.class,id);
        s.setName(name);
        tx.commit();
        em.close();
        emf.close();
    }

    static void removeData(int id){
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("sampleapp");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Student s = em.find(Student.class,id);
        em.remove(s);
        tx.commit();
        em.close();
        emf.close();
    }

    static List<Student> getAllData(){

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();;

        Query q = em.createQuery("select p from Student p "); //p is placeholder ie jpql
        List<Student> list = q.getResultList();

        tx.commit();
        em.close();
        emf.close();

        return list;
    }



    public static void main(String[] x){


        //save data
        Student s = new Student();
        s.setId(106);
        s.setName("b2");
        s.setMarks(20);
        saveData(s);

//        Student s1 = new Student();
//        s.setId(107);
//        s.setName("b2");
//        s.setMarks(20);
//        saveData(s);
//
//        Student s2 = new Student();
//        s.setId(106);
//        s.setName("b2");
//        s.setMarks(20);
//        saveData(s);

//        search data
        Student s3 = searchData(106);
        System.out.println(s);



//        update data
//        updateData(106,"kj");

        //delete data
//        removeData(106);

//        List<Student> list = getAllData();
//        for(Student s : list){
//            System.out.println(s);
//        }


    }
}






