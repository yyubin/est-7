package org.example.demospring.demo2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DemoService {
    private final DemoRepository demoRepository;
}
