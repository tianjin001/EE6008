package com.onlineLibrary.controller;


import com.onlineLibrary.DTO.BooksPageQueryDTO;
import com.onlineLibrary.Entity.Books;
import com.onlineLibrary.result.PageResult;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/home")
public class HomePageController {

    @Autowired
    private HomePageService homePageService;
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 条件查询书籍并分页展示
     * @param booksPageQueryDTO
     * @return
     */
    //条件查询 非homepage多功能查询
    @GetMapping("/page")
    @CrossOrigin()
    public Result<PageResult> pageQuery(BooksPageQueryDTO booksPageQueryDTO){
        PageResult pageResult = homePageService.pageQuery(booksPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 评分最高书籍/新书籍展示
     * @return
     */
    @GetMapping()
    @CrossOrigin()
    public Result<Map<String,List<Books>>> topBooksQuery(){

        List<Books> topBooks = homePageService.topbooksQuery();
        List<Books> newBooks = homePageService.newbooksQuery();

        Map<String, List<Books>> result = new HashMap<>();
        result.put("topBooks", topBooks);
        result.put("newBooks", newBooks);

        return Result.success(result);
    }
    @GetMapping("/recent-papers")
    public Result<?> getRecentPapers() {

        String url = "https://api.openalex.org/works"
                + "?sort=cited_by_count:desc"
                + "&select=title,authorships,publication_year,cited_by_count,doi"
                + "&per-page=10";


        // 调用 OpenAlex API
        Map response = restTemplate.getForObject(url, Map.class);
        //System.out.println("OpenAlex API Response: " + response);
        if (response != null) {
            return Result.success(response);
        } else {
            return Result.error("获取论文数据失败");
        }

    }

}
