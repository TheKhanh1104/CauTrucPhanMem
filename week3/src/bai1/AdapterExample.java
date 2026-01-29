// 1. Hệ thống cũ (Adaptee) - Chỉ trả về XML
package bai1;

class LegacyXmlSystem {
    public String getXmlData() {
        return "<order><id>123</id><status>Shipped</status></order>";
    }
}

// 2. Giao diện mục tiêu (Target) - Hệ thống mới yêu cầu JSON
interface JsonService {
    String getJsonData();
}

// 3. Bộ chuyển đổi (Adapter)
class XmlToJsonAdapter implements JsonService {
    private LegacyXmlSystem legacySystem;

    public XmlToJsonAdapter(LegacyXmlSystem legacySystem) {
        this.legacySystem = legacySystem;
    }

    @Override
    public String getJsonData() {
        String xmlData = legacySystem.getXmlData();
        
        // Logic chuyển đổi giả lập từ XML sang JSON
        System.out.println("--- Đang chuyển đổi dữ liệu XML sang JSON ---");
        String jsonData = xmlData.replace("<order><id>", "{ \"id\": ")
                                 .replace("</id><status>", ", \"status\": \"")
                                 .replace("</status></order>", "\" }");
        return jsonData;
    }
}

// --- Main để chạy thử ---
public class AdapterExample {
    public static void main(String[] args) {
        // Hệ thống cũ
        LegacyXmlSystem oldSystem = new LegacyXmlSystem();

        // Sử dụng Adapter để làm việc với hệ thống mới
        JsonService adapter = new XmlToJsonAdapter(oldSystem);

        System.out.println("Kết quả JSON cuối cùng: " + adapter.getJsonData());
    }
}