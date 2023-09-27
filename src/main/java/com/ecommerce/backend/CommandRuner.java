package com.ecommerce.backend;

import com.ecommerce.backend.entity.DistrictEntity;
import com.ecommerce.backend.entity.SubDistrictEntity;
import com.ecommerce.backend.repository.DistrictRepository;
import com.ecommerce.backend.repository.SubDistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;

//@Configuration
public class CommandRuner implements CommandLineRunner {
    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private SubDistrictRepository subRepo;

    @Override
    public void run(String... args) throws IOException {
        File file = ResourceUtils.getFile("classpath:sub_501.txt");
        String[] content = new String(Files.readAllBytes(file.toPath())).split(";");
        ArrayList<SubDistrictEntity> subDistrictEntities = new ArrayList<>();
        for (String std : content) {
            String[] vals = std.split("[\\,\\(\\)]");
            System.out.println(vals[8]);
            SubDistrictEntity subdistrict = new SubDistrictEntity();
            Integer id = Integer.parseInt(vals[1].trim());
            Integer code = Integer.parseInt(vals[2].trim());
            String nameTh = vals[3].trim();
            Integer disId = Integer.parseInt(vals[7].trim());

            DistrictEntity district = districtRepository.findById(disId).orElseThrow(() -> new RuntimeException("ROLE NOT FOUND"));;


            subdistrict.setId(id);
            subdistrict.setCode(code);
            subdistrict.setNameTh(nameTh);
            subdistrict.setDistrict(district);
            if (!vals[4].trim().equals("null")) {
                String nameEn = vals[4].trim();
                subdistrict.setNameEn(nameEn);
            }
            if (!vals[8].trim().equals("null")) {
                Integer zipcode = Integer.parseInt(vals[8].trim());
                subdistrict.setZipcode(zipcode);

            }

            subDistrictEntities.add(subdistrict);
        }
        subRepo.saveAll(subDistrictEntities);
//        BufferedReader buf = new BufferedReader(new FileReader(file));
//        String[] stds = buf.lines().collect(Collectors.joining()).split(";");
//        for (String std : stds) {
//            String[] values = std.split("[\\,/]");
//            System.out.println(values);
//
//            SubDistrictEntity subdistrict = new SubDistrictEntity();
//            Integer id = Integer.parseInt(values[1].trim());
//            Integer code = Integer.parseInt(values[2].trim());
//            String nameTh = values[3].trim();
//            String nameEn = values[4].trim();
//            String disId = values[7].trim();
//            Integer zipcode = Integer.parseInt(values[8].trim());
//
////			DistrictEntity dis = disRepo.getById(Integer.parseInt(disId));
////			subdistrict.setId(id);
////			subdistrict.setCode(code);
////			subdistrict.setNameEn(nameEn);
////			subdistrict.setNameEn(nameTh);
////			subdistrict.setZipcode(zipcode);
////			subdistrict.setDistrict(dis);
//        }
    }
}
