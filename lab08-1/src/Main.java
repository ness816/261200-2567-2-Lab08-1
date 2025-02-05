public class Main {
    public static void main(String[] args) {
        // สร้างและเริ่ม 3 เธรด พร้อมระบุหมายเลขของเธรดแต่ละตัว
        Thread t1 = new Thread(new NumberPrinter(1));
        Thread t2 = new Thread(new NumberPrinter(2));
        Thread t3 = new Thread(new NumberPrinter(3));

        t1.start();
        t2.start();
        t3.start();

        // รอให้ทุกเธรดทำงานเสร็จสิ้นโดยใช้ join()
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // ถ้า main thread ถูก interruption ให้ออกจากโปรแกรม
            return;
        }

        /*
            ก่อนเพิ่ม Thread.sleep():
            - ลำดับของการดำเนินการไม่คงที่ ตัวเลขจากเธรดต่างๆ จะผสมกันแบบสุ่ม
            - เธรดบางเธรดพิมพ์ตัวเลขหลายตัวติดกันก่อนจะไปใช้เธรดอื่น

            หลังจากเพิ่ม Thread.sleep():
            - ตัวเลขจะปรากฏสลับกัน แต่มีการสุ่มมากขึ้นเนื่องจากความล่าช้าของโหมดพักเครื่อง
            - เธรดอาจพิมพ์เลขสลับกันตลอดเวลา
            - เธรดที่มีปัญหาความล่าช้าของโหมดพักเครื่องนานกว่าอาจพิมพ์ตัวเลขได้ช้ากว่าเธรดอื่นๆ

            มัลติเธรดใน Java
           - Java ใช้เธรดเพื่อให้หลายงานทำพร้อมกันได้  ไม่ต้องรอให้เสร็จทีละอย่าง
           - ตัวจัดการของ JVM จะเป็นคนเลือกว่าเธรดไหนได้ทำงานก่อน ทำให้ผลลัพธ์ออกมาแบบเดายาก ไม่มีลำดับตายตัว
           - พอใส่ sleep() เข้าไป มันเหมือนกับว่าเป็นตัวตั้งเวลาพักให้เธรด ทำให้ผลลัพธ์ยิ่งสุ่มมากกว่าเดิม เพราะบางเธรดอาจหยุดรอ ส่วนอีกเธรดก็ทำงานต่อ
           - ทุกครั้งที่รันโปรแกรมจะไม่รู้ว่าเธรดไหนมาก่อนมาหลัง  ลำดับของผลลัพธ์จะไม่เหมือนกันเลย

         */

    }
}