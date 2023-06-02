package com.NseDataFeed.service;

import com.NseDataFeed.Entity.OptionChain;
import com.NseDataFeed.Repository.OptionChainRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class OptionChainService {

    @Autowired
    private OptionChainRepository optionChainRepository;


    public void saveOptionChainData()throws IOException{
        String url= "https://www.nseindia.com/api/option-chain-indices?symbol=NIFTY";
//        String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:65.0) Gecko/20100101 Firefox/65.0";
        //Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36
        Document doc = Jsoup.connect(url).ignoreContentType(true)
                .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36")
                .get();

        ObjectMapper objectMapper=new ObjectMapper();
        // code for CE data

        JsonNode rootNode = objectMapper.readTree(doc.text());
        System.out.println(rootNode);
        JsonNode recordNode = rootNode.path("records");
        System.out.println(recordNode.get("records"));
        for(JsonNode reJsonNode:recordNode){
            String symbol=recordNode.path("symbol").asText();
//            LocalDate expDate=LocalDate.parse(recordNode.path("expiryDate").asText(),
//                    DateTimeFormatter.ofPattern("dd-mm-yyy"));
            JsonNode ceNode=recordNode.path("CE");
            Double ceStrikePrice = ceNode.path("strikePrice").asDouble();
            Double ceOpenInterest=ceNode.path("openInterest").asDouble();
            Double ceChangeInOpenInterest=ceNode.path("ChangeInOpenInterest").asDouble();
            Double ceImpliedVolatility=ceNode.path("impliedVolatility").asDouble();

            OptionChain ceOptionChain = new OptionChain();
            ceOptionChain.setSymbol(symbol);
//            ceOptionChain.setExpiryDate(expDate);
            ceOptionChain.setStrikePrice(ceStrikePrice);
            ceOptionChain.setOpenInterest(ceOpenInterest);
            ceOptionChain.setChangeInOpenInterest(ceChangeInOpenInterest);
            ceOptionChain.setImpliedVolatility(ceImpliedVolatility);

            optionChainRepository.save(ceOptionChain);

            // code for PE data
            JsonNode peNode=recordNode.path("PE");
            Double peStrikePrice = ceNode.path("strikePrice").asDouble();
            Double peOpenInterest=ceNode.path("openInterest").asDouble();
            Double PeChangeInOpenInterest=ceNode.path("ChangeInOpenInterest").asDouble();
            Double PeImpliedVolatility=ceNode.path("impliedVolatility").asDouble();

            OptionChain peOptionChain = new OptionChain();
            peOptionChain.setSymbol(symbol);
//            peOptionChain.setExpiryDate(expDate);
            peOptionChain.setStrikePrice(ceStrikePrice);
            peOptionChain.setOpenInterest(ceOpenInterest);
            peOptionChain.setChangeInOpenInterest(ceChangeInOpenInterest);
            peOptionChain.setImpliedVolatility(ceImpliedVolatility);

            optionChainRepository.save(peOptionChain);

        }
    }
}
