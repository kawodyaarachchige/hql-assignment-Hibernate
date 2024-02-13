package org.example;

import org.example.config.FactoryConfiguration;
import org.example.entity.Books;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
public class Main {
    public static void main(String[] args) {


        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        /*
        q1.String hql = "from Books b where b.publicationYear > 2010";
        Query query = session.createQuery(hql);
        List <Books> list = query.list();

        for(Books b:list){
            System.out.println(b.getId()+" "+b.getTitle()+" "+b.getPublicationYear()+" "+b.getPrice());
        }
*/     /* q2 String hql = " UPDATE Books b SET price = b.price /100 *110 WHERE b.author.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", 1);
        int isUpdated = query.executeUpdate();
        System.out.println(isUpdated> 0 ? "Updated" : "Not Updated");
*//*
      q4 String hql = " select avg(b.price) from Books b";
        Query query = session.createQuery(hql);
        double avg = (double) query.getSingleResult();
        System.out.println(avg);*/
/*
       q5 String hql = "select  a.name , count(b) from Author a left join a.books b group by a.name";
        Query query = session.createQuery(hql);
        List <Object[]> list = query.list();

        for(Object[] obj:list){
            System.out.println(obj[0]+" "+obj[1]);
        }*/

       /*  q6 String hql = "select a.name, b.title from Author a inner join a.books b where a.country =:country";
        Query query = session.createQuery(hql);
        query.setParameter("country", "Pakistan");
        List <Object[]> list = query.list();
        for (Object[] obj:list){
            System.out.println(obj[0]+" "+obj[1]);
        }*/

        //10
       /* Query query = session.createQuery("SELECT a.name FROM Author a WHERE ( SELECT COUNT(b.id) FROM Books b" +
                " WHERE a.id = b.author.id ) > ( SELECT AVG(authorBookCount) FROM ( SELECT COUNT(b.id) AS authorBookCount " +
                "FROM Books b GROUP BY b.author.id ))");
        List<String> resultList = query.getResultList();

        for (String s : resultList) {
            System.out.println(s);
        }
*/     /* String hql = "delete from Author a where a.id = : author";
        Query query = session.createQuery(hql);
        query.setParameter("author", 1);
        int isDeleted = query.executeUpdate();
        System.out.println(isDeleted > 0 ? "Deleted" : "Not Deleted");*/

        String hqlDeleteBooks = "delete from Books b where b.author.id = :authorId";
        Query queryDeleteBooks = session.createQuery(hqlDeleteBooks);
        queryDeleteBooks.setParameter("authorId", 1);
        int deletedBooksCount = queryDeleteBooks.executeUpdate();
        System.out.println("Deleted " + deletedBooksCount + " associated books");

        String hqlDeleteAuthor = "delete from Author a where a.id = :authorId";
        Query queryDeleteAuthor = session.createQuery(hqlDeleteAuthor);
        queryDeleteAuthor.setParameter("authorId", 1);
        int deletedAuthorCount = queryDeleteAuthor.executeUpdate();
        System.out.println(deletedAuthorCount > 0 ? "Author deleted" : "Author not found");



        transaction.commit();
        session.close();


    }
}