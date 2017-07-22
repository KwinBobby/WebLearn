package org.beta.android.aakashresearchlabs.test;

import java.util.ArrayList;

/**
 * Created by Kevin on 6/25/2017.
 */

//Contains all the questions for the app

public class ListOfQuestions {

    ArrayList<String> answers;
    ArrayList<QuestionClass> singlequiz;
    static ArrayList<ArrayList<QuestionClass>> totalCollection;
    QuestionClass QandA=new QuestionClass();
    // ArrayList<ArrayList<HashMap<String,ArrayList<String>>>> quizCollection;

    public void fillquestion()
    {
        answers=new ArrayList<>();
        singlequiz=new ArrayList<>();
        totalCollection=new ArrayList<>();

        fillup("The key words about alt text are","Constructive text","Descriptive text","Assertive text","Alternative text.",3);
        fillup("Users with significant visual impairments often use tools called __________ to read   out the alt text to them.","Screen readers","Text readers","Word readers","Set readers",1);
        fillup("HTML contains _____ heading levels","Four","Five","Six","Seven",2);
        fillup("___________ are for lists where the order of the items doesn't matter.","Ordered lists","Unordered lists","Specified lists","Non specified lists",1);
        fillup("Example of an ordered list is","Recipe","Shopping list","List of students","Grocery list",0);
        fillup("To add a link, we need to use","<a>","<b>","<c>","<d>",0);

        totalCollection.add(singlequiz);
        singlequiz=new ArrayList<>();

        fillup("<a> stands for","Adhere","Anchor","Add","None of these",2);
        fillup("The https:// or http:// part is called the","Web address","Address","Protocol","tAll of the above",3);
        fillup("Href stands for","Hypertext reference","Hypertext reframe","Hypertext reform","Hypertext reframe",0);


        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup("____________ is the programming language that you use to add interactive features to your website, for example games, things that happen when buttons are pressed or data is entered in forms, dynamic styling effects, animation, and much more.","Java","C++","JavaScript","None of these",2);
        fillup("JavaScript was invented by_________","Brendan Eich","James Gosling","Larry Wall","Dennis Ritchie",0);
        fillup("APIs stands for","Application Program Interfaces","Application Project Interfaces","Automated Program Interfaces","None of these",0);
        fillup("DOM stands for","Design object model","Device object model","Document object model","None of these",2);
        fillup("A variable cannot start with  a/an","Alphabet","Number","None of these","Both of these",1);
        fillup("A structure that allows you to store multiple values in one single reference is called a/an","Document","File","Set","Array",3);
        fillup("CSS stands for","Creative stylesheets","Cascading stylesheets","Computer stylesheets","None of these",1);
        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup(" What is CSS?","Markup Language ","Style Sheet Language ","Programming Language","All of the above",3);
        fillup("What is used to separate a property from its values?",":",";","\\","/",1);
        fillup("The space around the content is?","Border","Padding ","Margin","Frame",2);
        fillup("What does the first pixel value represent?","How far it moves across"," How far it moves down","How much it zooms in","How much it zooms out ",0);
        fillup("The body element is?","Block level element ","Inline element ","Box element ","Outline element ",2);
        fillup("What does psuedo class selector select?","the element on the page with specified ID ","the element on the page with psuedo class","the element on the page with specified attribute ","the specified element in the specified state ",2);
        fillup("__________ looks specifically at the area of testing web projects across different browsers","cross browser testing","complex browsing test","differential browser testing","Congruent browser testing ",0);


        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup("What code do you use to see your website online via github?","username.github.io","username.github.ic","username.github.uv","username.github.ip",0);
        fillup("GitHub: Social coding :: ________ : Building and running of applications","Google Store","Google App ","Android store","Android  App",2);


        totalCollection.add(singlequiz);

        singlequiz=new ArrayList<>();
        fillup("How is data transferred across the internet?","via pockets","via packets ","via chunks","via quanta ",1);
        fillup(" __________ matches your web address to the website's IP address","Default Number Singularity ","Domain Node Specificity","Domain Name Servers ","Default Note Servers ",2);
        fillup("_______ and ________ are communication protocols","TCP/IP","TCP/UDP","FTP/IP","IP/HTML",0);
        fillup("The two types of component files are?","Crypt files and Assets ","Mac OS and Mac CS","Clients and Server files","Code files and Assets",3);
        fillup("","","","","",2);

        totalCollection.add(singlequiz);


        singlequiz=new ArrayList<>();
        fillup("What is dynamic websites- server  programming?","series of modules that show how to create dynamic websites","series of dynamic modules that show to accomplish server side programming","series of modules that  show how to create websites ","dynamic model that clubs multiple websites together ",0);
        fillup("What web frameworks are expressed to create basic applications?","(Node.js/javascript)","(node.Js/JavaScript)","(Node.js/JavaScript)","None of the above",0);
        fillup("What is a browser?","Tool which helps you browse the internet ","Website viewer ","Used for surfing the internet ","All of the above",3);
        fillup("What language is Django Web framework written in?","COBOL","C++","Python","FORTRAN ",2);
        fillup("_____ is a technology used t add in further semantics and assistive technologies","A-JAX ","AJAX","ARIA-WAI ","WAI-ARIA",3);
        fillup("__________ is not an example of online coding program","JSBin","JSFiddle","Thimble","None of the above ",3);

        totalCollection.add(singlequiz);


    }

    void fillup(String question, String answer1,String answer2,String answer3,String answer4,int correctAnswerIndex)
    {
        QandA=new QuestionClass();
        answers=new ArrayList<>();
        answers.add(answer1);
        answers.add(answer2);
        answers.add(answer3);
        answers.add(answer4);
        QandA.setQuestion(question);
        QandA.setOptions(answers);
        QandA.setCorrectAnswerIndex(correctAnswerIndex);
        singlequiz.add(QandA);
    }


}
