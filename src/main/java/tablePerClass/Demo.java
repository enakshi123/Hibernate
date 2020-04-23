package tablePerClass;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
    public static void main(String [] args){
        A a=new A();
        a.setId(101);
        a.setName("abc");

        B b=new B();
        b.setId(102);
        b.setName("def");
        b.setValueOne("b1");

        C c =new C();
        c.setId(103);
        c.setName("ghi");
        c.setValueTwo("c1");


        EntityManagerFactory emf= Persistence.createEntityManagerFactory("sampleapp");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
//        Student s1=em.find(Student.class,1);

//            em.persist(s);
//        System.out.println(s.getAddress().isEmpty());
        em.persist(a);
        em.persist(b);
        em.persist(c);

        tx.commit();
        em.close();
        emf.close();

    }
}
