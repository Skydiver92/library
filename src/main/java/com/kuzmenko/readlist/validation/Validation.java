//package com.kuzmenko.readlist.validation;
//
//public class Validation {
//
//    public void Сheck()
//    {
//        if (Date == null) throw new ArgumentNullException("Дата не указана");
//        DateTime parsedDate;
//        try {
//            parsedDate = DateTime.Parse(Date);
//        }
//        catch (FormatException e) {
//            throw new ArgumentException("Дата указана в неизвестном формате", e);
//        }
//        if (parsedDate < DateTime.Now) throw new ArgumentException("Дата не может быть раньше сегодняшней");
//        if (NumberOfSeats == null) throw new ArgumentException("Количество мест не указано");
//        if (NumberOfSeats < 1) throw new ArgumentException("Количество мест должно быть положительным числом");
//    }
//
//}
