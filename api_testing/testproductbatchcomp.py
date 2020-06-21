import json
from API.productbatchcomp   import ProductBatchComp

print('TESTING PRODUCTBATCHCOMP STARTED')

print('LIST1 test started!')
com_test    = ProductBatchComp()
_list       = json.loads(com_test.list())
print(json.dumps(_list, indent=4))
print('LIST1 test complete!')

print('LIST2 test started!')
max_pre_id  = max([x['productBatch_id'] for x in _list])
_list       = json.loads(com_test.list(max_pre_id))
print(json.dumps(_list, indent=4))
print('LIST2 test complete!')

print('GET test started!')
max_com_id  = max([x['commodityBatch_id'] for x in _list])
obj         = com_test.get(max_pre_id, max_com_id)
print(obj)
print('GET test complete!')

print('CREATE test started!')
com_test.setJson(max_pre_id, max_com_id+1, 1, 1.1, 2.2)
response    = com_test.create(com_test.json)
print(response)
print('CREATE test complete')

print('UPDATE test started!')
com_test.setJson(max_pre_id, max_com_id+1, 1, 3.3, 4.4)
response    = com_test.update(com_test.json)
print(response)
print('UPDATE test complete')

print('TESTING PRODUCTBATCHCOMP COMPLETE')
