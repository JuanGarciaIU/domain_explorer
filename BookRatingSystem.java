import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BookRatingSystem {

    private static Scanner input = new Scanner(System.in);
    private static Book[]bookCatalog = new Book[10];
    private static Book selectedBook;

    

    public static void main(String[] args) {
        mainMenu();

    }

// Main menu
    private static void mainMenu(){

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1) Admin Menu");
            System.out.println("2) User Menu");
            System.out.println("3) Display all books");
            System.out.println("4) Exit");
            System.out.println("Please enter valid choice");
            int selection = input.nextInt();
            input.nextLine(); 

            switch (selection){

                case 1:
                System.out.println("Enter the username (admin): ");
                String username = input.nextLine();
                System.out.println("Enter the password(pass); ");
                String password = input.nextLine();

                if (adminAccess(username, password)) {
                    
                    adminMenu();
                } else {
                    System.out.println("Incorrect username or password");
                    mainMenu();
                    return;
                }

                adminMenu();
                break;

                case 2:
                userMenu();
                break;

                case 3:
                displayBookCatalog();
                break;

                case 4:
                // Exit System
                System.out.println( "Confirm to exit program (Y) or return to menu (N)");
                String confirmation = input.nextLine();
                if (confirmation.equals("Y") || confirmation.equals("y")) {
                    System.exit(0);
                }
                else 
                {
                    System.out.println("Returning to main menu");
                    break;
                    
                }

        }

    }

}

private static boolean adminAccess(String username, String password){

    String adminUsername = "admin";
    String adminPassword = "pass";
    
    return username.equals(adminUsername) && password.equals(adminPassword);

}

private static void adminMenu(){


    
    System.out.println("Admin Menu:");
    System.out.println("1) Add new book");
    System.out.println("2) Update a book");
    System.out.println("3) Delete a book");
    System.out.println("4) Delete a comment about a book");
    System.out.println("5) Return to Main Menu ");

    System.out.println("Please enter valid choice");
    int selection = input.nextInt();

        switch (selection){

            case 1:
            addNewBook();
            break;

            case 2:
            updateBook();
            break;

            case 3:
            deleteBook();
            break;

            case 4:
            deleteBookComment();
            break;

            case 5:
            //Exit admin menu
            return;
                
    }

}

private static void userMenu(){
    System.out.println("Main Menu:");
    System.out.println("1) Search book");
    System.out.println("2) Rate book");
    System.out.println("3) Add a comment to a book");
    System.out.println("4) Like a comment about a book");
    System.out.println("5) Return to Main Menu");

    System.out.println("Please enter valid choice");
    int selection = input.nextInt();

    switch (selection){

        case 1:
        searchBook();
        break;

        case 2:
        rateBook();
        break;

        case 3:
        commentOnBook(selectedBook);
        break;

        case 4:
        likeBookComment();
        break;

        case 5:
        //Exit user menu
        return;
    
    }

}

private static void displayBookCatalog() {
    System.out.println("Books in the Catalog:");
    for (Book book : bookCatalog) {
        if (book != null) {
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Description: " + book.getDescription());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Publisher: " + book.getPublisher());
            System.out.println("Publication Date (Year): " + book.getPubDate());
            System.out.println("Number of Pages: " + book.getPageNum());
            System.out.println("Retail Price: " + book.getRetailPrice());
            System.out.println("Number of Copies Sold: " + book.getCopiesSold());
            System.out.println("Average Rating: " + book.getAverageRating());

        }
    }
}

 
    // Admin menu

    private static void addNewBook() {
        Book newBook = new Book();

        int isbn;
    
        while (true) {
            try {
                System.out.println("ISBN:");
                isbn = input.nextInt();
                input.nextLine();
                newBook.setISBN(isbn);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry, Enter a valid number.");
                input.nextLine();
            }
        }
    
        for (Book book : bookCatalog) {
            if (book != null && book.getISBN() == isbn) {
                System.out.println("ISBN is already in use");
                adminMenu();
                return;
            }
        }
    
        System.out.println("Title: ");
        String title = input.nextLine();
        newBook.setTitle(title);
    
        System.out.println("Description: ");
        String description = input.nextLine();
        newBook.setDescription(description);
    
        System.out.println("Author: ");
        String author = input.nextLine();
        newBook.setAuthor(author);
    
        System.out.println("Publisher: ");
        String publisher = input.nextLine();
        newBook.setPublisher(publisher);
    
        int pubDate;
        while (true) {
            try {
                System.out.println("Publication Date (Year): ");
                pubDate = input.nextInt();
                input.nextLine();
                newBook.setPubDate(pubDate);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry, Enter a valid number.");
                input.nextLine();
            }
        }
    
        int pageNum;
        while (true) {
            try {
                System.out.println("Number of Pages: ");
                pageNum = input.nextInt();
                input.nextLine();
                newBook.setPageNum(pageNum);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry, Enter a valid number.");
                input.nextLine();
            }
        }
    
        int retailPrice;
        while (true) {
            try {
                System.out.println("Retail Price: ");
                retailPrice = input.nextInt();
                input.nextLine();
                newBook.setRetailPrice(retailPrice);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry, Enter a valid number.");
                input.nextLine();
            }
        }
    
        int copiesSold;
        while (true) {
            try {
                System.out.println("Number of Copies Sold: ");
                copiesSold = input.nextInt();
                input.nextLine();
                newBook.setCopiesSold(copiesSold);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry, Enter a valid number.");
                input.nextLine();
            }
        }
    
        for (int i = 0; i < bookCatalog.length; i++) {
            if (bookCatalog[i] == null) {
                bookCatalog[i] = newBook;
                System.out.println("New book added");
                return;
            }
        }
    }
    


    private static void updateBook() {
        try{
            System.out.println("Search for a book using ISBN or book title (1 for ISBN, 2 for title): ");
            int searchMethod = input.nextInt();
            input.nextLine();
        
            String searchTerm;
            if (searchMethod == 1) {
                System.out.println("Enter the ISBN for the book: ");
                searchTerm = input.nextLine();
            } else if (searchMethod == 2) {
                System.out.println("Enter a portion of the title: ");
                searchTerm = input.nextLine().toLowerCase();
            } else {
                System.out.println("Invalid search method.");
                return;
            }
        
            List<Book> matchingBooks = new ArrayList<>();
            for (Book book : bookCatalog) {
                if (book != null) {
                    if (searchMethod == 1 && String.valueOf(book.getISBN()).equals(searchTerm)) {
                        matchingBooks.add(book);
                    } else if (searchMethod == 2 && book.getTitle().toLowerCase().contains(searchTerm)) {
                        matchingBooks.add(book);
                    }
                }
            }
        
            if (matchingBooks.isEmpty()) {
                System.out.println("No matching books found.");
            } else if (matchingBooks.size() == 1) {
                updateBookDetails(matchingBooks.get(0));
            } else {
                System.out.println("Matching books:");
                for (int i = 0; i < matchingBooks.size(); i++) {
                    Book book = matchingBooks.get(i);
                    System.out.println((i + 1) + ") ISBN: " + book.getISBN() + ", Title: " + book.getTitle());
                }
                System.out.println("Please enter the number of the book you want to select:");
                int selection = input.nextInt();
                input.nextLine();
                if (selection > 0 && selection <= matchingBooks.size()) {
                    updateBookDetails(matchingBooks.get(selection - 1));
                } else {
                    System.out.println("Invalid selection.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid choice.");
            input.nextLine(); 
        }
    }

    
    private static void updateBookDetails(Book book) {
        System.out.println("The book you have selected is " + book.getTitle());
        System.out.println("What would you like to update?");
        System.out.println("1) Title");
        System.out.println("2) Description");
        System.out.println("3) Author");
        System.out.println("4) Publisher");
        System.out.println("5) Publication Date (Year)");
        System.out.println("6) Number of Pages");
        System.out.println("7) Retail Price");
        System.out.println("8) Number of Copies Sold");
        System.out.println("9) Go back to main menu");
    
        int selection = input.nextInt();
        input.nextLine();
    
        switch (selection) {
            case 1:
                System.out.println("Enter the new Title: ");
                String title = input.nextLine();
                book.setTitle(title);
                break;
            case 2:
                System.out.println("Enter the new description: ");
                String description = input.nextLine();
                book.setDescription(description);
                break;
            case 3:
                System.out.println("Enter the new author: ");
                String author = input.nextLine();
                book.setAuthor(author);
                break;
            case 4:
                System.out.println("Enter the new publisher: ");
                String publisher = input.nextLine();
                book.setPublisher(publisher);
                break;
            case 5:
                System.out.println("Enter the new publication date (Year): ");
                int pubDate = input.nextInt();
                book.setPubDate(pubDate);
                break;
            case 6:
                System.out.println("Enter the new number of pages: ");
                int pageNum = input.nextInt();
                book.setPageNum(pageNum);
                break;
            case 7:
                System.out.println("Enter the new Retail Price: ");
                int retailPrice = input.nextInt();
                book.setRetailPrice(retailPrice);
                break;
            case 8:
                System.out.println("Enter the new Copies Sold: ");
                int copiesSold = input.nextInt();
                book.setCopiesSold(copiesSold);
                break;
            case 9:
                adminMenu();
                return;
            default:
                System.out.println("Invalid selection");
                break;
        }
    
        System.out.println("Book details updated successfully.");
        adminMenu();
    }
    
    

    
    private static void deleteBook() {
        int deleteISBN = 0;
        
        for (Book book : bookCatalog) {
            if (book != null) {
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Title: " + book.getTitle());
            }
        }
    
        while (true) {
            try {
                System.out.println("Enter the ISBN for the book you want to delete or 0 to quit.  ");
                deleteISBN = input.nextInt();
                input.nextLine(); 
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry, Enter a valid number.");
                input.nextLine(); 
            }
        }

        if (deleteISBN == 0) {
            System.out.println("Deletion canceled.");
            adminMenu();
            return;
        }


    
        boolean found = false;
        for (int i = 0; i < bookCatalog.length; i++) {
            Book book = bookCatalog[i];
            if (book != null && book.getISBN() == deleteISBN) {
                System.out.println("Are you sure you want to delete the book" + book.getTitle()  + "(Y/N)");
                String selection = input.nextLine();
                if (selection.equals("y")){
                bookCatalog[i] = null;
                found = true;
                System.out.println("Book has been removed");
                }else {
                    System.out.println("Book deletion canceled");

                }
                break;
                
            }
        }
    
        if (!found) {
            System.out.println("Wrong ISBN entered or book does not exist");
        }
    
        adminMenu();
    }
    

private static void deleteBookComment(){
    try{
            System.out.println("Search for a book using ISBN or book title (1 for ISBN, 2 for title): ");
            int searchMethod = input.nextInt();
            input.nextLine();

            String searchTerm;
            if (searchMethod == 1) {
                System.out.println("Enter the ISBN for the book: ");
                searchTerm = input.nextLine();
            } else if (searchMethod == 2) {
                System.out.println("Enter a portion of the title: ");
                searchTerm = input.nextLine().toLowerCase();
            } else {
                System.out.println("Invalid search method.");
                return;
            }

            List<Book> matchingBooks = new ArrayList<>();
            for (Book book : bookCatalog) {
                if (book != null) {
                    if (searchMethod == 1 && String.valueOf(book.getISBN()).equals(searchTerm)) {
                        matchingBooks.add(book);
                    } else if (searchMethod == 2 && book.getTitle().toLowerCase().contains(searchTerm)) {
                        matchingBooks.add(book);
                    }
                }
            }

            if (matchingBooks.isEmpty()) {
                System.out.println("No matching books found.");
            } else if (matchingBooks.size() == 1) {
                bookCommets(matchingBooks.get(0));
            } else {
                System.out.println("Matching books:");
                for (int i = 0; i < matchingBooks.size(); i++) {
                    Book book = matchingBooks.get(i);
                    System.out.println((i + 1) + ") ISBN: " + book.getISBN() + ", Title: " + book.getTitle());
                }
                System.out.println("Please enter the number of the book you want to select:");
                int selection = input.nextInt();
                input.nextLine();
                if (selection > 0 && selection <= matchingBooks.size()) {
                    bookCommets(matchingBooks.get(selection - 1));
                } else {
                    System.out.println("Invalid selection.");
                }
            }
            
        }catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid choice.");
            input.nextLine(); 
        }
    }
    

    private static void bookCommets(Book book) {
                Comment[] comments = book.getComments();
            
                System.out.println(book.getTitle() + " Comments:");
            
                if (comments != null && comments.length > 0) {
                    for (int i = 0; i < comments.length; i++) {
                        Comment comment = comments[i];
                        if (comment != null) {

                        System.out.println((i + 1) + ") Comment: " + comment.getText() + " Likes: " + comment.getNumLikes());
                    }
                }
                } else {
                    System.out.println("No comments available.");
            }
    
        adminMenu();
    }
    
//User menu 

    private static void searchBook() {
        try{
            System.out.println("Search for book using ISBN or book title (1 for ISBN, 2 for title): ");
                int searchMethod = input.nextInt();
                input.nextLine(); 
                
                String searchTerm;
                if (searchMethod == 1) {
                    System.out.println("Enter the ISBN for the book: ");
                    searchTerm = input.nextLine();
                } else if (searchMethod == 2) {
                    System.out.println("Enter a portion of the title: ");
                    searchTerm = input.nextLine().toLowerCase(); 
                } else {
                    System.out.println("Invalid search method.");
                    return;
                }
                
                List<Book> matchingBooks = new ArrayList<>();
                for (Book book : bookCatalog) {
                    if (book != null) {
                        if (searchMethod == 1 && String.valueOf(book.getISBN()).equals(searchTerm)) {
                            matchingBooks.add(book);
                        } else if (searchMethod == 2 && book.getTitle().toLowerCase().contains(searchTerm)) {
                            matchingBooks.add(book);
                        }
                    }
                }
                
                if (matchingBooks.isEmpty()) {
                    System.out.println("No matching books found.");
                } else if (matchingBooks.size() == 1) {
                    displayBookDetails(matchingBooks.get(0));
                } else {
                    System.out.println("Matching books:");
                    for (int i = 0; i < matchingBooks.size(); i++) {
                        Book book = matchingBooks.get(i);
                        System.out.println((i + 1) + ") ISBN: " + book.getISBN() + ", Title: " + book.getTitle());
                    }
                    System.out.println("Please enter the number of the book you want to select:");
                    int selection = input.nextInt();
                    input.nextLine(); 
                    if (selection > 0 && selection <= matchingBooks.size()) {
                        displayBookDetails(matchingBooks.get(selection - 1));
                    } else {
                        System.out.println("Invalid selection.");
                    }
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid choice.");
                input.nextLine(); 
            }
        }
            
            private static void displayBookDetails(Book book) {
                System.out.println("Book details:");
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Description: " + book.getDescription());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Publisher: " + book.getPublisher());
                System.out.println("Publication Date (Year): " + book.getPubDate());
                System.out.println("Number of Pages: " + book.getPageNum());
                System.out.println("Retail Price: " + book.getRetailPrice());
                System.out.println("Number of Copies Sold: " + book.getCopiesSold());
                System.out.println("Average Rating: " + book.getAverageRating());
                
                Comment[] comments = book.getComments();
            
                System.out.println(book.getTitle() + " Comments:");
                if (comments != null) {
                    for (int i = 0; i < comments.length; i++) {
                        Comment comment = comments[i];
                        if (comment != null) {
                            System.out.println((i + 1) + ") Cooment: " + comment.getText() + " Likes: " + comment.getNumLikes());
                        }
                    }
                } else {
                    System.out.println("No comments available.");
                }
            
                selectedBook = book;
                userMenu();
            }
            
            


private static void rateBook(){

    if (selectedBook == null) {
        System.out.println("Search for the book first.");
        return;
        }

    System.out.println("Rate the book " + selectedBook.getTitle() + " from 1 - 10: ");
    int bookRating = input.nextInt();
    input.nextLine();

    while (bookRating < 1 || bookRating > 10){

        System.out.println("Enter a valid rating for the book " + selectedBook.getTitle() + " from 1 - 10: ");
        bookRating = input.nextInt();
        input.nextLine();

    }
    selectedBook.setBookRating(bookRating);
    System.out.println();


    selectedBook.addRating(bookRating);
    System.out.println("Thank you for rating the book!");


    System.out.println("Book: " + selectedBook.getTitle());
    System.out.println("Average Rating: " + selectedBook.getAverageRating());
    System.out.println("Total Ratings: " + selectedBook.getTotalRatings());

    userMenu();
    return;

}

            


private static void commentOnBook(Book book) {

    if (selectedBook == null) {
        System.out.println("Search for the book first.");
        return;
    }

    System.out.println("Enter your comment: ");
    input.nextLine();
    String commentText = input.nextLine();


    
    Comment[] comments = book.getComments();
    int index = -1;
    for (int i = 0; i < comments.length; i++) {
        if (comments[i] == null) {
            index = i;
            break;
        }
    }

    if (index == -1) {
        System.out.println("No space available for new comments.");
        return;
    }

    Comment newComment = new Comment();
    newComment.setText(commentText);
    comments[index] = newComment;

    System.out.println("Comment added successfully.");

    userMenu();
    return;
}



private static void likeBookComment() {

    if (selectedBook == null) {
        System.out.println("Search for book using ISBN or book title (1 for ISBN, 2 for title): ");
        return;
    }    
    System.out.println("Couldn't figure out how to do it");
    userMenu();
    return;
 
}



static class Book {

    private int ISBN;
    private String Title;
    private String Description;
    private String Author;
    private String Publisher;
    private int PubDate;
    private int PageNum;
    private int RetailPrice;
    private int CopiesSold;
    private Comment[] comments = new Comment[10];
    private int bookRating;
    private int totalRatings;
    private double averageRating;

        public int getISBN() {
            return ISBN;
        }

        public void setISBN(int ISBN) {
            this.ISBN = ISBN;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String title) {
            this.Title = title;
        }

        public String getDescription() {
            return Description;
        }

        public void setDescription(String description) {
            this.Description = description;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String author) {
            this.Author = author;
        }

        public String getPublisher() {
            return Publisher;
        }

        public void setPublisher(String publisher) {
            this.Publisher = publisher;
        }

        public int getPubDate() {
            return PubDate;
        }

        public void setPubDate(int pubDate) {
            this.PubDate = pubDate;
        }

        public int getPageNum() {
            return PageNum;
        }

        public void setPageNum(int pageNum) {
            this.PageNum = pageNum;
        }

        public int getRetailPrice() {
            return RetailPrice;
        }

        public void setRetailPrice(int retailPrice) {
            this.RetailPrice = retailPrice;
        }

        public int getCopiesSold() {
            return CopiesSold;
        }

        public void setCopiesSold(int copiesSold) {
            this.CopiesSold = copiesSold;
        }

        public Comment[] getComments() {
            return comments;
        }
    
        public void setComments(Comment[] comments) {
            this.comments = comments;
        }

        public int getBookRating() {
            return bookRating;
        }
        
        public void setBookRating(int bookRating) {
            this.bookRating = bookRating;
        }

        public void addRating(int rating) {
            totalRatings++;
            averageRating = ((averageRating * (totalRatings - 1)) + rating) / totalRatings;
        }
    
        public double getAverageRating() {
            return averageRating;
        }
        
        public int getTotalRatings() {
            return totalRatings;
        }


        }
    
    }

    class Comment {
        private String text; 
        private int numLikes;
    
    
        public String getText() {
            return text;
        }
    
        public void setText(String text) {
            this.text = text;
        }
    
        public int getNumLikes() {
            return numLikes;
        }
    
        public void setNumLikes(int numLikes) {
            this.numLikes = numLikes;
        }
    }

