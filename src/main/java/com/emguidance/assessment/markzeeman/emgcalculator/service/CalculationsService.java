package com.emguidance.assessment.markzeeman.emgcalculator.service;

import com.emguidance.assessment.markzeeman.emgcalculator.model.Calculation;
import com.emguidance.assessment.markzeeman.emgcalculator.model.Profile;
import com.emguidance.assessment.markzeeman.emgcalculator.model.ProfileHolder;
import com.emguidance.assessment.markzeeman.emgcalculator.repository.CalculationsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.util.JSONWrappedObject;
import com.google.gson.Gson;
import com.oracle.javafx.jmx.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.*;

@Service
@Path("calculations")
public class CalculationsService {

    Logger logger = LoggerFactory.getLogger(CalculationsService.class);


    private final CalculationsRepository repository;

    public CalculationsService(CalculationsRepository repository) {
        this.repository = repository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Calculation> getCalculations() {
        return repository.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCalculation(@PathParam("id") Long id) {
        Calculation calculation = repository.findById(id).orElseThrow(NotFoundException::new);
        // I am an edited comment

        logger.info("Processing getCalculation{id}" + calculation);
        logger.info("Processing getCalculation{idwe}" + calculation);

        return Response.ok(calculation).build();
    }

    @POST
    @Path("evaluateProfileDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSome(ProfileHolder profile) {

        String[] requiredFields = {"dob", "idNumber", "gender","address","provinces", "schools", "grades","serialNumber", "imei"};

        List<String> fieldsStillRequired = new ArrayList<>();

        for(String requiredField: requiredFields)
        {
            Field field = null;
            try {
                field = profile.getProfile().getClass().getDeclaredField(requiredField);
                field.setAccessible(true);
                Object value = field.get(profile.getProfile());

                if(value==null){
                    fieldsStillRequired.add(requiredField);
                }

                System.out.println("value : " +value);
            } catch (NoSuchFieldException | IllegalAccessException e) {

                System.out.println("No such field exists.");

                e.printStackTrace();
            }

        }

        return Response.ok(fieldsStillRequired).build();
    }

    @POST
    @Path("evaluateandupdateprofiledetails")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSome2(ProfileHolder profile) {

        String[] requiredFields = {"dob", "idNumber", "gender","address","provinces", "schools", "grades","serialNumber", "imei"};

        List<String> fieldsStillRequired = new ArrayList<>();

        for(String requiredField: requiredFields)
        {
            Field field = null;
            try {
                field = profile.getProfile().getClass().getDeclaredField(requiredField);
                field.setAccessible(true);
                Object value = field.get(profile.getProfile());

                if(value==null){
                    fieldsStillRequired.add(requiredField);
                }

                System.out.println("value : " +value);
            } catch (NoSuchFieldException | IllegalAccessException e) {

                System.out.println("No such field exists.");

                e.printStackTrace();
            }

        }

        for(String requiredField: fieldsStillRequired)
        {
            Field field = null;
            try {
                field = profile.getProfile().getClass().getDeclaredField(requiredField);
                field.setAccessible(true);
                Object value = field.get(profile.getProfile());

                if(value==null){
                    field.set(profile.getProfile(),"Updated");
                }

                System.out.println("value : " +value);
            } catch (NoSuchFieldException | IllegalAccessException e) {

                System.out.println("No such field exists.");

                e.printStackTrace();
            }

        }

        return Response.ok(profile).build();
    }



    public static Map<String, Object> toMap(JSONObject jsonobj) throws JSONException, org.json.JSONException {
        Map<String, Object> map = new HashMap<String, Object>();
        Iterator<String> keys = jsonobj.keys();
        while(keys.hasNext()) {
            String key = keys.next();
            Object value = jsonobj.get(key);
            if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }   return map;
    }


    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response postCalculation(@QueryParam(value="inputNumber1") String inputNumber1,
                                  @QueryParam(value="inputNumber2") String inputNumber2,
                                  @QueryParam(value="operator") String operator) throws URISyntaxException{

        logger.info("Processing postCalculation:  inputNumber1:" + inputNumber1+ "     inputNumber2"+ inputNumber2 + "    operator:"+operator );

        logger.info("Processing postCalculation:  inputNumber1:" + inputNumber1+ "     inputNumber2"+ inputNumber2 + "    operator:"+operator );

        logger.info("Processing postCalculation:  inputNumber1:" + inputNumber1+ "     inputNumber2"+ inputNumber2 + "    operator:"+operator );

        logger.info("Processing postCalculation:  inputNumber1:" + inputNumber1+ "     inputNumber2"+ inputNumber2 + "    operator:"+operator );

        // ZBHango
        String z=null;
        String response =null;

        logger.info("Processing postCalculation:  inputNumber1:" + inputNumber1+ "     inputNumber2"+ inputNumber2 + "    operator:"+operator );

        // Mark
        String b=null;
        if(!validNumberCheck(inputNumber1, "inputNumber1").isEmpty()){
            response=validNumberCheck(inputNumber1,"inputNumber1");
        }

        if(!validNumberCheck(inputNumber2,"inputNumber2").isEmpty()){
            response=validNumberCheck(inputNumber2,"inputNumber2");
        }


        String answer;
        if(response==null){
            answer= determineCalculation(operator,Double.valueOf(inputNumber1),Double.valueOf(inputNumber2));
            Calculation calculation = new Calculation();
            calculation.setInputNumber1(Double.valueOf(inputNumber1));
            calculation.setInputNumber2(Double.valueOf(inputNumber2));
            calculation.setDateCreated(new Date());
            calculation.setOperator(operator);
            calculation.setAnswer(answer);
            Calculation result = repository.save(calculation);
    //Check calc
            logger.info("Processed postCalculation:  inputNumber1:" + inputNumber1+  "    operator:"+operator+"     inputNumber2"+ inputNumber2 +"    result:"+result.getAnswer());
            return Response.status(200).entity("\""+answer+"\"").build();
        }else{
            logger.info("Error Processing postCalculation:  inputNumber1:" + inputNumber1+  "    operator:"+operator+"     inputNumber2"+ inputNumber2 +"    result:"+response);
            return Response.status(400).entity("\""+response+"\"").build();
        }
    }

    private ArrayList<String> initialiseValidOperatorList(){
        ArrayList<String> validOperators = new ArrayList<>();
        validOperators.add("PLUS");
        validOperators.add("MINUS");
        validOperators.add("PRODUCT");
        validOperators.add("DIVIDE");
        return validOperators;
    }

    /**
     *
     * **/
    private String determineCalculation(String inputOperator,double num1, double num2){
        ArrayList<String> validOperators = initialiseValidOperatorList();
        String answer="";
        if(inputOperator!=null && ! inputOperator.isEmpty()){
            switch (inputOperator.toUpperCase()) {
                case "PLUS":
                    answer = String.valueOf(num1+num2);
                    break;
                case "MINUS":
                    answer = String.valueOf(num1-num2);
                    break;
                case "PRODUCT":
                    answer = String.valueOf(num1*num2);
                    break;
                case "DIVIDE":
                    if(num2==0){
                        answer ="Cannot divide by 0 Calculation : "+ num1+" / "+num2;
                    }else{
                            answer = String.valueOf(num1/num2);
                    }
                    break;
                default:answer ="inputOperator  :  "+inputOperator+ " is not an accepted operator for this calculation \n"+"Operators Accepted are: "+validOperators.toString();
            }
        }


        return answer;

    }

    private Integer isInteger(double answer){
        if(answer%1==0){
            return Integer.valueOf(String.valueOf(answer));
        }
        return null;
    }

    private String validNumberCheck(String input, String valueName){
        String response="";
        try{
            Double num2 = Double.valueOf(input);
        }
        catch(NumberFormatException ex){
            response=valueName +" : " +  input+ " is not a valid number. We can only perform calculations with a valid number + \n";
        }
        return response;
    }
}
