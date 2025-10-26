🔗 URL Shortener Service

A simple Spring Boot URL Shortener that converts long URLs into short Base62 codes, stores them in an H2 database, and supports redirection with click tracking.

⚙️ Tech Stack

Java 21

Spring Boot 3.5.6

H2 Database

Swagger UI

🚀 Run Locally
git clone https://github.com/<your-username>/url-shortener.git
cd url-shortener
mvn spring-boot:run


Swagger UI:
👉 http://localhost:8080/swagger-ui/index.html

🧩 Endpoints
Method	Endpoint	Description
POST	/shorten?url=<longUrl>	Creates a short code
GET	/{shortCode}	Redirects to original URL

Example:

# Create short URL
curl -X POST "http://localhost:8080/shorten?url=https://spring.io"

# Redirect
curl -L "http://localhost:8080/abc123"

🧠 Code Example
@RestController
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) { this.service = service; }

    @PostMapping("/shorten")
    public String shorten(@RequestParam String url) {
        return service.shortenUrl(url);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        String original = service.getOriginalUrl(code);
        return ResponseEntity.status(HttpStatus.FOUND)
                             .location(URI.create(original)).build();
    }
}

🧾 Features

✅ Base62 short code generation
✅ H2 in-memory storage
✅ Redirect with analytics
✅ Swagger documentation

📈 Future Enhancements

Expiry time for URLs

Custom short codes

User authentication

Author: Aniket Singh
