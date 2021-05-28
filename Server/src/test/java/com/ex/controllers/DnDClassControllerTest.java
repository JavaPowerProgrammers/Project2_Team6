//package com.ex.controllers;
//
//import com.ex.pojos.player.DnDClass;
//import com.ex.services.DnDClassService;
//import org.junit.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.ResponseEntity;
////@RunWith(SpringRunner.class)
////@SpringBootTest
//public class DnDClassControllerTest
//{
//    @Autowired
//    private DnDClassController dnDClassController;
//
//    @Autowired
//    private DnDClassService dnDClassService;
//
//    private DnDClass dnDClass1;
//    private DnDClass dnDClass2;
//
//    @BeforeClass
//    public static void setUpClass()
//    {
////        MongoConnector connector = new MongoConnector();
////        connector.configure(() -> {
////            CodecProvider codecProvider = PojoCodecProvider.builder().register("com.ex.pojos").build();
////            CodecRegistry registry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(codecProvider));
////            return MongoClientSettings.builder()
////                    .applyConnectionString(connector.newConectionString("mongodb://localhost:27017/ers"))
////                    .retryWrites(true)
////                    .codecRegistry(registry)
////                    .build();
////        }).createClient();
////
//////        md = new MongoManagerDao(connector, "ers", "managerstest");
////        ms = new MongoManagerService(md);
////        mc = new DnDClassController(ms);
//
//    }
//
//    @Before
//    public void setUp() throws Exception
//    {
//        dnDClass1 = new DnDClass(); //david
//        dnDClass2 = new DnDClass(); //david
//        dnDClassService.save(dnDClass1);
//        dnDClassService.save(dnDClass2);
//    }
//
//    @After
//    public void tearDown() throws Exception
//    {
//        dnDClassService.delete(dnDClass1);
//        dnDClassService.delete(dnDClass2);
//    }
//
//    @Test
//    public void getAllDnDClasses() {
//        ResponseEntity expected = null;
//        ResponseEntity actual =  dnDClassController.getAllDnDClasses();
//
//        Assert.assertEquals(expected, actual);
//    }
//}