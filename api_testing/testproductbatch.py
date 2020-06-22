import json
from API.productbatch       import ProductBatch

print('TESTING PRODUCTBATCH STARTED')

print('LIST test started!')
com_test    = ProductBatch()
_list       = json.loads(com_test.list())
print(json.dumps(_list, indent=4))
print('LIST test complete!')

print('GET test started!')
max_pro_id      = max([x['productBatch_id'] for x in _list])
max_pre_id      = max([x['prescription_id'] for x in _list])
obj         = com_test.get(max_pro_id)
print(obj)
print('GET test complete!')

print('CREATE test started!')
com_test.setJson(max_pro_id+1, max_pre_id, 1)
response    = com_test.create(com_test.json)
print(response)
print('CREATE test complete')

print('UPDATE is not relevant for this one,')
print('scince it is done thoug productbatchcomp')

print('TESTING PRODUCTBATCH COMPLETE')
