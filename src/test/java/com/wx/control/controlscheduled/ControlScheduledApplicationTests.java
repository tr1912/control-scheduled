package com.wx.control.controlscheduled;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
class ControlScheduledApplicationTests {

    @Test
    void contextLoads() {
        EntityTest e1 = new EntityTest(5,1,"a");
        EntityTest e2 = new EntityTest(1,2,"b");
        EntityTest e3 = new EntityTest(2,3,"b");
        EntityTest e4 = new EntityTest(5,4,"b");
        EntityTest e5 = new EntityTest(3,5,"c");
        EntityTest e6 = new EntityTest(1,6,"e");
        EntityTest e7 = new EntityTest(4,7,"c");
        EntityTest e8 = new EntityTest(3,8,"d");
        EntityTest e9 = new EntityTest(2,9,"d");
        List<EntityTest> l1 = new ArrayList<>();
        l1.add(e1);
        l1.add(e2);
        l1.add(e3);
        l1.add(e4);
        l1.add(e5);
        l1.add(e6);
        l1.add(e7);
        l1.add(e8);
        l1.add(e9);
        Map<Integer, List<EntityTest>> collect = l1.stream().collect(Collectors.groupingBy(n -> n.getNumStatus()));
        System.out.println(collect);
//        Map<Integer, Long> numStatusMap = l1.stream().collect(Collectors.groupingBy(EntityTest::getNumStatus, Collectors.counting()));
//        Map<Integer, Long> statusMap = l1.stream().collect(Collectors.groupingBy(EntityTest::getStatus, Collectors.counting()));

//        System.out.println(numStatusMap);
//        System.out.println(statusMap);

    }

    class EntityTest{

        public EntityTest(Integer numStatus, Integer status, String name) {
            this.numStatus = numStatus;
            this.status = status;
            this.name = name;
        }

        private Integer numStatus;

        private Integer status;

        private String name;

        public Integer getNumStatus() {
            return numStatus;
        }

        public void setNumStatus(Integer numStatus) {
            this.numStatus = numStatus;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    enum statusEn{

        S1("1",1),
        S2("2",2),
        S3("3",3),
        ERROR("E",999);

        statusEn(String name, Integer status) {
            this.name = name;
            this.status = status;
        }

        private String name;

        private Integer status;

        public static String getEnumName(Integer status){
            return Arrays.asList(statusEn.values()).stream().filter(statusEn -> statusEn.getStatus().equals(status)).findFirst().orElse(statusEn.ERROR).getName();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }

    enum numStatusEn{

        S1("1",1),
        S2("2",2),
        S3("3",3),
        S4("4",4);

        numStatusEn(String name, Integer status) {
            this.name = name;
            this.status = status;
        }

        private String name;

        private Integer status;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }
    }
}