package com.example.unstructureddatabasecomparator.controller;

import com.example.unstructureddatabasecomparator.service.neo4j.Neo4JService;
import com.example.unstructureddatabasecomparator.service.postgresql.PostgresService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {"/", "/home"})
@RequiredArgsConstructor
@SessionAttributes("data")
@EnableAsync
public class HomeController {

  private final Neo4JService neo4JService;
  private final PostgresService postgresService;

  @ModelAttribute("data")
  public List<List<Object>> initData() {

    List<List<Object>> data = new ArrayList<>();

    for (int i = 0; i < 4; i++) {

      List<Object> row = new ArrayList<>();
      row.add("Execute Query Level " + i);
      row.add(null);
      row.add(null);
      row.add(null);
      data.add(row);
    }

    return data;
  }

  @GetMapping
  public String getHomePage(Model model) {
    return "home";
  }

  @GetMapping("/loadDataset")
  public String loadDataset(Model model) {

    postgresService.loadDataset();
    neo4JService.loadDataset();

    return "home";
  }

  @GetMapping("/executeQueries")
  public String executeQueries(@RequestParam(name = "row") int row, @ModelAttribute("data") List<List<Object>> data) {

    Double postgresTime;
    Double neo4JTime;

    switch (row) {
      case 0 -> {
        postgresTime = postgresService.executeFistQuery();
        neo4JTime = neo4JService.executeFistQuery();
      }
      case 1 -> {
        postgresTime = postgresService.executeSecondQuery();
        neo4JTime = neo4JService.executeSecondQuery();
      }
      case 2 -> {
        postgresTime = postgresService.executeThirdQuery();
        neo4JTime = neo4JService.executeThirdQuery();
      }
      case 3 -> {
        postgresTime = postgresService.executeFourthQuery();
        neo4JTime = neo4JService.executeFourthQuery();
      }
      default -> {
        postgresTime = 0.0;
        neo4JTime = 0.0;
      }
    }

    updateModel(data, row, postgresTime, neo4JTime);

    return "home";
  }

  private void updateModel(List<List<Object>> data, int row, Double postgresTime, Double neo4JTime) {

    data.get(row).set(1, postgresTime);
    data.get(row).set(2, neo4JTime);
    data.get(row).set(3, Math.abs(postgresTime - neo4JTime));
  }
}
