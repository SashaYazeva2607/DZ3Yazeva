import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.UUID;
import java.util.Scanner;

////public class Main {
////    public static void main(String[] args) {
////
////    }
//}

//Задача 1  Класс "Человек" Создайте класс Person с полями name, age, gender. Реализуйте методы для вывода информации о человеке и увеличения его возраста. Добавьте метод для изменения имени.
class Person {
    public String name;
    public  int age;
    public char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void getInfo() {
        System.out.println("Имя: " + name + ", Возраст: " + age + ", Пол: " + gender);
    }

    public void Age() {
        age++;
    }

    public void changeName(String newName) {
        name = newName;
    }
}

//Задача 2 Наследование: Класс "Работник" и "Менеджер"
//Создайте класс Worker, который наследуется от класса Person, и добавьте поле salary. Создайте класс Manager, который наследует от Worker и добавляет поле для подчиненных сотрудников.
class Worker extends Person{
    public int salary;
    public Worker(String name, int age, char gender, int salary) {
        super(name, age, gender);
        this.salary = salary;
    }
}
class Manager extends Worker{
    public int[] workers;
    public Manager(String name, int age, char gender, int salary, int[]workers) {
        super(name, age, gender, salary);
        this.workers = workers;
    }
}

//Задача 3 Полиморфизм: Животные
//Создайте интерфейс Animal с методом makeSound(). Реализуйте классы Dog, Cat, и Cow, которые реализуют этот интерфейс. Продемонстрируйте полиморфизм на примере массива животных.
interface Animal {
    void makeSound();
}
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Гав");
    }
}
class Cat implements Animal {
    public void makeSound() {
        System.out.println("Мяу");
    }
}
class Cow implements Animal {
    public void makeSound() {
        System.out.println("Му");
    }
}
public class Main {
    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Cow()};
        for (Animal animal : animals) animal.makeSound();
    }
}


//Задача 4 Абстрактный класс "Транспорт"
//Создайте абстрактный класс Transport с абстрактным методом move(). Реализуйте классы Car и Bike, которые наследуются от Transport и реализуют метод move().
abstract class Transport {
    abstract void move();
}
class Car extends Transport {
    void move() {
        System.out.println("Врум");
    }
}
class Bike extends Transport {
    void move() {
        System.out.println("Бум");
    }
}

//Задача 5 Класс "Книга" и "Библиотека"
//Создайте класс Book с полями title, author, и year. Создайте класс Library, который содержит коллекцию книг и методы для добавления книг, поиска по автору и году публикации.

class Book {
    public String title;
    public String author;
    public int year;
    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
}
class Library {
    public ArrayList<Book> books;
    public Library(ArrayList<Book> books){
        this.books = books;
    }
    public void addBook(Book book) {
        books.add(book);
    }
    public void findAuthor(String author) {
        for (Book book : books)
            if (book.author.equals(author))
                System.out.println("Автор книги " + book.author);
    }
    public void findYear(int year) {
        for (Book book : books)
            if (book.year == year)
                System.out.println("Год публикации " + book.year);
    }
}

//Задача 6  Инкапсуляция: Банк
//Создайте класс BankAccount с полями accountNumber, balance, и методами для пополнения и снятия средств. Обеспечьте инкапсуляцию для безопасности данных счета.
class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber, int balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    public void replenishment(double sum) {
        balance += sum;
    }
    public void withdraw(double sum) {
        if (sum <= balance) balance -= sum;
        else System.out.println("Не хватает средств для списания");
    }
    public double Balance() {
        return balance;
    }
}

//Задача 7 Счетчик объектов
//Создайте класс Counter, который хранит количество созданных объектов данного класса. Реализуйте статическое поле для учета количества объектов и метод для его увеличения при каждом создании объекта.
class Counter {
    private static int x = 0;
    public Counter() {
        x++;
    }
    public static int getCount() {
        return x;
    }
}

//Задача 8 Площадь фигур
//Создайте абстрактный класс Shape с абстрактным методом getArea(). Реализуйте классы Circle и Rectangle, которые наследуют от Shape и вычисляют площадь круга и прямоугольника соответственно.
abstract class Shape {
    abstract double getArea();
}
class Circle extends Shape {
    public double radius;
    public Circle(double radius) {
        this.radius = radius;
    }
    double getArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    public double h;
    public double w;

    public Rectangle(double h, double w) {
        this.h = h;
        this.w = w;
    }
    double getArea() {
        return h * w;
    }
}

//Задача 9 Наследование: Животные и их движения
//Создайте класс Animal с методом move(). Реализуйте классы Fish, Bird и Dog, которые наследуют Animal и переопределяют метод move() (рыба плавает, птица летает, собака бегает).
class Animall {
    void move() {
        System.out.println("Животное движется");
    }
}
class Dogg extends Animall {
    void move() {
        System.out.println("Собака бегает");
    }
}
class Fish extends Animall {
    void move() {
        System.out.println("Рыба плавает");
    }
}
class Bird extends Animall {
    void move() {
        System.out.println("Птица летает");
    }
}


//Задача 10   Работа с коллекциями: Университет
//Создайте класс Student с полями name, group, grade. Создайте класс University, который содержит список студентов и методы для добавления студентов, сортировки по имени и фильтрации по успеваемости.

class Student {
    public String name;
    public String group;
    public double grade;
    public Student(String name, String group, int grade) {
        this.name = name;
        this.group = group;
        this.grade = grade;
    }
    public String getName(){
        return name;
    }
}
class University {
    public ArrayList<Student> students;

    public University(ArrayList<Student> students){
        this.students = students;
    }
    public void add(Student student) {
        students.add(student);
    }
    public void sort() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }
    public void filter(double Grade) {
        for (Student student : students)
            if (student.grade >= Grade)
                System.out.println(student.name);
    }
}

//Задача 11 Класс "Магазин"
//Реализуйте класс Product с полями name, price, и quantity. Создайте класс Store, который содержит список продуктов и методы для добавления, удаления и поиска товаров по имени.

class Product {
    public String name;
    public double price;
    public int quantity;
    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
class Store {
    public ArrayList<Product> products = new ArrayList<>();
    public Store(ArrayList<Product> products){
        this.products = products;
    }
    public void add(Product product) {
        products.add(product);
    }
    public void remove(Product product) {
        products.remove(product);
    }
    public Product findName(String name) {
        for (Product product : products)
            if (product.name.equals(name)) return product;
        return null;
    }
}

//Задача 12 Интерфейс "Платежная система"
//Создайте интерфейс PaymentSystem с методами pay() и refund(). Реализуйте классы CreditCard и PayPal, которые реализуют этот интерфейс.
interface PaymentSystem {
    void pay();
    void refund();
}
class CreditCard implements PaymentSystem {
    public void pay() {
        System.out.println("Вы оплатили");
    }
    public void refund() {
        System.out.println("Деньги пришли");
    }
}
class PayPal implements PaymentSystem {
    public void pay() {
        System.out.println("ggre");
    }
    public void refund() {
        System.out.println("vdddf");
    }
}

//Задача 13  Генерация уникальных идентификаторов
//Создайте класс UniqueID, который генерирует уникальные идентификаторы для объектов каждого созданного класса. Реализуйте этот функционал через статическое поле и метод.

class UniqueID {
    private static int x = 0;
    private String id;

    public UniqueID() {
        this.id = UUID.randomUUID().toString();
        x++;
    }
    public static int Count() {
        return x;
    }
    public String Id() {
        return id;
    }
}

//Задача 14 Класс "Точка" и "Прямоугольник"
//Создайте класс Point с координатами x и y. Реализуйте класс Rectangle, который содержит две точки (левая верхняя и правая нижняя). Реализуйте метод для вычисления площади прямоугольника.
class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class Rectanglee {
    public Point left;
    public Point right;

    public Rectanglee(Point topLeft, Point bottomRight) {
        this.left = topLeft;
        this.right = bottomRight;
    }
    public double getArea() {
        return (left.x - right.x) * (right.y - left.y);
    }
}

//Задача 15 Комплексные числа
//Создайте класс ComplexNumber с полями для действительной и мнимой частей. Реализуйте методы для сложения, вычитания, умножения и деления комплексных чисел.
class ComplexNumber {
    public double real;
    public double unreal;

    public ComplexNumber(double real, double unreal) {
        this.real = real;
        this.unreal = unreal;
    }

    public ComplexNumber add(ComplexNumber x) {
        return new ComplexNumber(this.real + x.real,
                this.unreal + x.unreal);
    }

    public ComplexNumber subtract(ComplexNumber x) {
        return new ComplexNumber(this.real - x.real,
                this.unreal - x.unreal);
    }

    public ComplexNumber multiply(ComplexNumber x) {
        return new ComplexNumber(this.real * x.real - this.unreal * x.unreal,
                this.real * x.unreal + this.unreal * x.real);
    }

    public ComplexNumber divide(ComplexNumber x) {
        double denominator = x.real * x.real + x.unreal * x.unreal;
        return new ComplexNumber((this.real * x.real + this.unreal * x.unreal) / denominator,
                (this.unreal * x.real - this.real * x.unreal) / denominator);
    }
}


//Задача 17  Создание игры с использованием ООП
//Реализуйте классы для небольшой текстовой игры, такие как Player, Enemy, Weapon, с полями и методами, описывающими их поведение.
class Player {
    private String name;
    private int hp;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.hp = health;
        this.weapon = weapon;
    }

    public String getName(){
        return name;
    }

    public void Attack(Enemy enemy) {
        System.out.println(name + " бъёт " + enemy.getName() +
                " при помощи " + weapon.getName() + " и наносит " +
                weapon.getDamage() + " единиц урона");
    }

    public void Heal(int hp){
        this.hp += hp;
        System.out.println("Игрок " + name + " подлечился на " + hp + "очков здоровья");
    }

    public void Hurt(Enemy enemy){
        hp -= enemy.getDamage();
        System.out.println(name + " получил " + enemy.getDamage() + " урона.");
    }
}

class Enemy {
    private String name;
    private int damage;

    public Enemy(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getDamage(){
        return damage;
    }
}

class Weapon {
    private String name;
    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    public String getName(){
        return name;
    }

    public int getDamage(){
        return damage;
    }
}

//Задача 18  Автоматизированная система заказов
//Создайте классы Order, Customer, и Product. Реализуйте систему, где можно добавлять заказы, отображать общую стоимость заказа и просматривать историю заказов.

class Order{
    private ArrayList<Product1> products = new ArrayList<>();

    public Order(ArrayList<Product1> products){
        this.products = products;
    }

    public void add(Product1 product) {
        products.add(product);
    }

    public void remove(Product1 product) {
        products.remove(product);
    }

    public void getList(){
        for(Product1 item: products) System.out.println(item.getName());
    }
    public double totalPrice() {
        double total = 0;
        for (Product1 product : products) total += product.getPrice();
        return total;
    }
}

class Customer{
    private String name;

    public Customer(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Order MakeOrder(ArrayList<Product1> order){
        return new Order(order);
    }
}

class Product1{
    private String name;
    private double price;

    public Product1(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public String getName(){
        return name;
    }
}

// Задача 19 Наследование: Электроника
//Создайте класс Device с полем brand и методами turnOn() и turnOff(). Реализуйте классы Smartphone и Laptop, которые наследуют от Device и добавляют уникальные методы, например, takePhoto() для смартфона.
class Device{
    private String brand;

    public Device(String brand){
        this.brand = brand;
    }

    public void turnOn(){
        System.out.println("Включено");
    }
    public void turnOff(){
        System.out.println("выключено");
    }
}

class SmartPhone extends Device{
    public SmartPhone(String brand) {
        super(brand);
    }
    public void takePhoto(){
        System.out.println("Фото сделано");
    }

}

class Laptop extends Device{

    public Laptop(String brand){
        super(brand);
    }
    public void Open(){
        System.out.println("Вы открыли ноутбук");
    }

}


//Задача 20 Игра "Крестики-нолики"
//Разработайте классы для игры "Крестики-нолики". Создайте класс Game, который управляет логикой игры, и классы Player, описывающие поведение игроков.
class Play {
    private String name;
    private char symbol;

    public Play(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char GetSymbol(){
        return symbol;
    }
}

class Game{
    private char[][] field;
    private Play player1;
    private Play player2;
    private Play currentPlayer;

    public Game(Play player1, Play player2){
        if(player1.GetSymbol() == player2.GetSymbol()){
            System.out.println("Вы не можете играть одинаковыми символами!");
            return;
        }
        this.player1 = player1;
        this.currentPlayer = player1;
        this.player2 = player2;
        field = new char[3][3];
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                field[i][j] = ' ';
            }
        }
    }

    public boolean Step(int a, int b){
        if(a > 3 || b > 3 || a < 1 || b < 1){
            System.out.println("Вы не можете ходить вне поля!");
            return false;
        }
        if(field[a-1][b-1] != ' ') {
            System.out.println("Это поле занято!");
            return false;
        }

        field[a-1][b-1] = currentPlayer.GetSymbol();
        currentPlayer = (currentPlayer == player1 ? player1 : player2);
        return true;
    }

    public boolean IsCurrentPlayerWin(){
        char symbol = currentPlayer.GetSymbol();
        for(int i = 0; i < 3; i++){
            if(field[i][0] == symbol && field[i][1] == symbol && field[i][2] == symbol) return true;
            else if(field[0][i] == symbol && field[1][i] == symbol && field[2][i] == symbol) return true;
        }
        if(field[0][0] == symbol && field[1][1] == symbol && field[2][2] == symbol ||
                field[0][2] == symbol && field[1][1] == symbol && field[2][0] == symbol)
            return true;

        return false;
    }

    public boolean IsFieldFull(){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                if(field[i][j] == ' ') return false;
            }
        }
        return true;
    }

    public void showField(){
        for(int i = 0; i<3;i++){
            for(int j = 0; j<3;j++){
                System.out.println(field[i][j] + " ");
            }
        }
    }

    public void Play(){
        Scanner in = new Scanner(System.in);
        while(true){
            showField();

            System.out.println("Введите координаты хода в формате \"xy\" где x-строка, а y-колонка;");
            int xy = in.nextInt();
            int x = xy/10;
            int y = xy%10;

            if(!Step(x,y)) continue;

            if(IsCurrentPlayerWin()){
                System.out.println(currentPlayer.getName() + " победил!");
                break;
            }
            else if(IsFieldFull()){
                System.out.println("Ничья!");
                break;
            }
        }
        in.close();
    }
}