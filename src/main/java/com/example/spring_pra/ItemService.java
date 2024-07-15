package com.example.spring_pra;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemrepository;

    public void saveItem(String title, Integer price) {
        Item item = new Item();

        // DB 컬럼을 private를 선언했기에 Setter로 받아야 함
        item.setTitle(title);
        item.setPrice(price);

        // 위에 선언한 jpa 객체 이름에 .save 하면 DB에 자동 저장
        itemrepository.save(item);
    }

    public Optional<Item> getItem(Long id) {
        // 왜 Optional 써야함? => JPA findById 만든 사람이 쓰라는데요
        Optional<Item> result = itemrepository.findById(id);

        return result;
    }

    public void editpost(Long id, String title, Integer price) {
            Item item1 = new Item();

            // jpa는 수정 문법이 따로 없어 id 항목어 덮어씌우는 방식으로 수정해야 함
            item1.setTitle(title);
            item1.setPrice(price);
            item1.id = Math.toIntExact(id);

            itemrepository.save(item1);



    }
}
