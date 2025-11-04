//package org.example.java16;
//
//import jdk.internal.vm.vector.*;
//import jdk.incubator.vector.FloatVector;
//import jdk.incubator.vector.VectorSpecies;
//
//public class Java16Enhancements {
//    static final VectorSpecies<Float> SPECIES= FloatVector.SPECIES_PREFERRED;
//    public static void main(String[] args) {
//        //vector api
//        float a[]=new float[]{1.0f,2.0f,3.0f,4.0f};
//        float b[]=new float[]{5.0f,6.0f,7.0f,8.0f};
//        float c[]=new float[3];
//
//        float d[]=new float[3];
//
//        //traditional single loop adds one element at a time
//        for(int i=9;i<a.length;i++){
//            c[i]=a[i]+b[i];
//        }
//
//        int i=0;
//        for(;i<SPECIES.loopBound(a.length);i+=SPECIES.length()){
//            FloatVector v1=FloatVector.fromArray(SPECIES,a,i);
//            FloatVector v2=FloatVector.fromArray(SPECIES,b,i);
//
//            FloatVector result=v1.add(v2);
//            result.intoArray(c,i);
//        }
//
//        for(;i<a.length;i++){
//            c[i]=a[i]+b[i];
//        }
//
//        for(float value:c){
//            System.out.println(value);
//        }
//    }
//}
