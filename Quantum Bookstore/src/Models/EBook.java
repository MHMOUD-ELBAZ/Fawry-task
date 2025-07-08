package Models;

import Services.MailService;

public class EBook extends Book implements Buyable{
    private FileType fileType;

    public EBook(String ISBN, String title, double price, int publishingYear, FileType fileType) {
        super(ISBN, title, price, publishingYear);
        this.fileType =  fileType;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public double buy(int quantity, String email, String address){
        MailService mailService = new MailService();
        mailService.send(this, email);

        return this.getPrice() * quantity;
    }
}
