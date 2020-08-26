package bitJeju.model;

import java.sql.Date;

public class ClassDto {
   private int classCode;
   private String className;
   private Date startDay;
   private Date endDay;
   private int totalDay;
   private String teacher;
   private int max;
   private String tcode;
   private String filePath;
   
   public int getClassCode() {
      return classCode;
   }

   public void setClassCode(int classCode) {
      this.classCode = classCode;
   }

   public String getClassName() {
      return className;
   }

   public void setClassName(String className) {
      this.className = className;
   }

   public Date getStartDay() {
      return startDay;
   }

   public void setStartDay(Date startDay) {
      this.startDay = startDay;
   }

   public Date getEndDay() {
      return endDay;
   }

   public void setEndDay(Date endDay) {
      this.endDay = endDay;
   }

   public int getTotalDay() {
      return totalDay;
   }

   public void setTotalDay(int totalDay) {
      this.totalDay = totalDay;
   }

   public String getTeacher() {
      return teacher;
   }

   public void setTeacher(String teacher) {
      this.teacher = teacher;
   }

   public int getMax() {
      return max;
   }

   public void setMax(int max) {
      this.max = max;
   }

   public String getTcode() {
      return tcode;
   }

   public void setTcode(String tcode) {
      this.tcode = tcode;
   }


   public String getFilePath() {
      return filePath;
   }

   public void setFilePath(String filePath) {
      this.filePath = filePath;
   }

   @Override
   public String toString() {
      return "ClassDto [classCode=" + classCode + ", className=" + className + ", startDay=" + startDay + ", endDay="
            + endDay + ", totalDay=" + totalDay + ", teacher=" + teacher + ", max=" + max + ", tcode=" + tcode
            + ", filePath=" + filePath + "]";
   }

   public ClassDto() {
      
   }
   
   public ClassDto(int classCode, String className, Date startDay, Date endDay, int totalDay, String teacher, int max,
         String tcode) {
      super();
      this.classCode = classCode;
      this.className = className;
      this.startDay = startDay;
      this.endDay = endDay;
      this.totalDay = totalDay;
      this.teacher = teacher;
      this.max = max;
      this.tcode = tcode;
   }

}