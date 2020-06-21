import json, requests

class ProductBatch:
    def setJson(self, probat_id, pre_id, status):
        self.json = {
            'prescription_id': pre_id,
            'productBatch_id': probat_id,
            'status': status,
            }

    def get(self, key):
        key = str(key)
        r = requests.get(f"https://api.mama.sh/ProductBatchs/ID/{key}")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def list(self):
        r = requests.get("https://api.mama.sh/ProductBatchs")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def create(self, obj):
        r = requests.post("https://api.mama.sh/ProductBatchs", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def update(self, obj):
        r = requests.put("https://api.mama.sh/ProductBatchs", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
